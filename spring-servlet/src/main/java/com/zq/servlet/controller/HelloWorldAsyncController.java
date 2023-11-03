package com.zq.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * {@link DeferredResult}
 * @author <a href="mailto:quanzhang875@gmail.com">quanzhang875</a>
 * @since  2023-11-03 15:23:06
 */
@EnableScheduling
@RestController
public class HelloWorldAsyncController {

	private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

	// 超时随机数
	private final Random random = new Random();

	@Scheduled(fixedRate = 5000)
	public void process() throws InterruptedException {			// 定时操作
		DeferredResult<String> result = null;

		do {
			result = queue.take();
			// 随机超时时间
			long timeout = random.nextInt(100);
			// 模拟等待时间，RPC 或者 DB 查询
			Thread.sleep(timeout);
			// 计算结果
			result.setResult("Hello,World-2");
			println("执行计算结果，消耗：" + timeout + " ms.");
		} while (result != null);
	}

	@GetMapping("/hello-world")
	public DeferredResult<String> helloWorld() {
		DeferredResult<String> result = new DeferredResult<String>(50L);

		// result.setResult("Hello,World");

		// 入队操作
		queue.offer(result);

		// 相当于 try 里的正常执行
		println("Hello,World-1");

		// 相当于 finally 执行，无论如何都会执行
		result.onCompletion(() -> {
			println("执行结束");
		});

		// 相当于 异常被 catch 住了
		result.onTimeout(() -> {
			println("执行超时");
		});

		return result;
	}

	@GetMapping("/callable-hello-world")
	public Callable<String> callableHelloWorld() {
		final long startTime = System.currentTimeMillis();

		println("Hello,World-1");

		return () -> {
			long costTime = System.currentTimeMillis() - startTime;
			println("执行计算结果，消耗：" + costTime + " ms.");
			return "Hello,World-2";
		};
	}

	@GetMapping("/completion-stage")
	public CompletionStage<String> completionStage(){
		final long startTime = System.currentTimeMillis();

		println("Hello,World-1");

		return CompletableFuture.supplyAsync(()->{
			long costTime = System.currentTimeMillis() - startTime;
			println("执行计算结果，消耗：" + costTime + " ms.");
			return "Hello,World-2"; // 异步执行结果
		});
	}

	public void println(Object object) {
		String threadName = Thread.currentThread().getName();
		System.out.println("HelloWorldAsyncController["+ threadName +"]: " + object);
	}

}
