package hello.core.singleton;

public class StatefulService {
//    private int price;  //가격 - 상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
        //this.price = price; //여기가 문제
        return price;   //그냥 들어온 그대로 넘겨버림
    }

//    public int getPrice(){
//        return price;
//    }
}
