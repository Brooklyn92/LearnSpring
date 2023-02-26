package studySpringFromAlishev;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

          //Конструкция без применения DI
//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer2.setVolume(10);
        musicPlayer.playMusic();
        musicPlayer2.playMusic();

        System.out.println("Звук первого плейера: " + musicPlayer.getVolume()); // => null, т.к. полученного бина scope =  Prototype
        System.out.println("Звук второго плейера: " + musicPlayer2.getVolume()); // => 10

        context.close();
    }
}
