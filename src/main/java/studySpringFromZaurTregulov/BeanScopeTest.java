package studySpringFromZaurTregulov;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Dog dog = context.getBean("myPet", Dog.class);
        Dog dog2 = context.getBean("myPet", Dog.class);
        dog.setName("Белка");
        dog2.setName("Стрелка");

        //Scope = singleton
        System.out.println("Перменные ссылкаются на один и тот же объект? " + (dog==dog2)); // => true, т.к. scope = singleton
        System.out.println(dog); // => хэшкод studySpringFromZaurTregulov.Dog@3bd82cf5
        System.out.println(dog2); // => хэшкод studySpringFromZaurTregulov.Dog@3bd82cf5
        System.out.println(dog.getName()); // => Стрелка
        System.out.println(dog2.getName()); // => Стрелка

        System.out.println("======================================================================");

        //Scope = prototype
        System.out.println("Перменные ссылкаются на один и тот же объект? " + (dog==dog2)); // => false, т.к. scope = prototype
        System.out.println(dog); // => хэшкод studySpringFromZaurTregulov.Dog@6ad82709
        System.out.println(dog2); // => хэшкод studySpringFromZaurTregulov.Dog@510f3d34
        System.out.println(dog.getName()); // => Белка
        System.out.println(dog2.getName()); // => Стрелка

        context.close();


    }
}
