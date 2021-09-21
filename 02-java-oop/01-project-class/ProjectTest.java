public class ProjectTest {
    public static void main(String[] args){
        Project a = new Project("Awesome Project", "This project is awesome!");
        String test = a.getName();
        System.out.println(test);
        a.setName("Even More Awesome Project");
        System.out.println(a.getName());
        System.out.println(a.elevatorPitch());
    }
}
