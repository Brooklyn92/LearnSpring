package studySpringFromZaurTregulov;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAndDITest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        //Код без DI
//        Pet pet = context.getBean("myPet", Pet.class);
//        Person person = new Person(pet);

        //Код с DI
        Person person = context.getBean("myPerson", Person.class);
        person.callYouPet();

        System.out.println("Имя: " + person.getName() + " и возраст: " + person.getAge());

        context.close();
    }
}
