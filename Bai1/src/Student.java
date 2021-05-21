public class Student {
    private String idStudent;
    private String name;
    private int ageStudent;
    private String address;

    public Student() {
    }

    public Student(String idStudent, String name, int agrStudent, String address) {
        this.idStudent = idStudent;
        this.name = name;
        this.ageStudent = agrStudent;
        this.address = address;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent='" + idStudent + '\'' +
                ", name='" + name + '\'' +
                ", agrStudent=" + ageStudent +
                ", address='" + address + '\'' +
                '}';
    }
}
