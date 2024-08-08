class example{
    public static void main(String[] args){
        Demo o1= new Demo();
        Demo o2= new Demo(25);
        o1.fun();

    }
}
class Demo{
    Demo(){
        System.out.println("Hello world");
    }
    Demo(int sac){
        System.out.println(sac);
    }
    void fun(){
        System.out.println("Hery");
    }
}