package com.jiawei.controller;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import javafx.collections.transformation.SortedList;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.SortedSet;

@RestController
public class HelloController {

    @RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    public String sayHello(){
        return "hello springBoot!";
    }


    public static void main(String[] args) {

        ImmutableSet<Integer> of = ImmutableSet.of(1, 2, 4, 5, 7, 1, 3);
        ImmutableSet<Integer> integers = ImmutableSet.copyOf(of);

        integers.stream().forEach(System.out::print);
    }
}
