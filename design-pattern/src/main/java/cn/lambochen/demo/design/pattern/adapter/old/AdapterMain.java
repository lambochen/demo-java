package cn.lambochen.demo.design.pattern.adapter.old;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description TODO
 **/
public class AdapterMain {

    public static void main(String[] args) {
        NoteBook noteBook = new NoteBook();

        TwoPhaseInterfaceAdapter adapter = new TwoPhaseInterfaceAdapter();
        adapter.setThree(new ThreePhaseInterfaceImpl());
        noteBook.setTwo(adapter);
        noteBook.power();

        System.out.println("******************");

        TwoPhaseInterfaceExtendsAdapter extendsAdapter = new TwoPhaseInterfaceExtendsAdapter();
        noteBook.setTwo(extendsAdapter);
        noteBook.power();
    }
}
