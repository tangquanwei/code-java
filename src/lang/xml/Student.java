package lang.xml;

public class Student {
    private String name;
    private int age;
    private int id;

    /**
     * @param name
     * @param age
     * @param id
     */
    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    Student() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + getName() + "\nid: " + getId() + "\nage: " + getAge();
    }

}
