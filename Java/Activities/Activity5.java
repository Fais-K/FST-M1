package activities;

public class Activity5 {
    public static void main(String[] args){
        MyBook newNovel = new MyBook();
        String title = "Hover Car Racer";
        newNovel.setTitle(title);

        System.out.println("The title is: " + newNovel.getTitle());

    }
}
