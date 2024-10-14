package org.example.deadlock;

import java.util.ArrayList;
import java.util.List;

public class SharedResources {
    public static final List<Integer> listA = new ArrayList<>();
    public static final List<Integer> listB = new ArrayList<>();
}
