package com.zq.autoconfigure.repository;

import com.zq.autoconfigure.annotation.FirstLevelRepository;
import com.zq.autoconfigure.annotation.SecondLevelRepository;

//@FirstLevelRepository("myFirstLevelRepository") // Bean 名称
@SecondLevelRepository("myFirstLevelRepository") // Bean 名称
public class MyFirstLevelRepository {
}
