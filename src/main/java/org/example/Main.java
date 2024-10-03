package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        // heap메모리가 지속적으로 우상향한다. -> 새로 생성된 객체들이 eden영역에 쌓임 -> eden이 꽉 차면 minor GC가 동작
        // -> 참조되지 않은 객체는 GC에 의해 제거되고 참조관계가 있는 객체는 살아남아서 survivor로 이동함.
        // 즉 list안의 객체는 살아남지만 그외 메소드 호출과정에서 생성된 스택 프레임, 메소드 호출시의 local변수들은 GC의 수거 대상이다.
        new Producer("_Producer 1").start();
        new Producer("_Producer 2").start();
        new Producer("_Producer 3").start();
        new Producer("_Producer 4").start();

//        new Consumer("_Consumer 1").start();
//        new Consumer("_Consumer 2").start();
    }
}