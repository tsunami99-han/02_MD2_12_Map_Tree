import sun.awt.SunHints;

import java.util.*;

public class StudentManager {
    HashMap<String, Student> studentMap = null;
    Scanner sc = new Scanner(System.in);

    public StudentManager() {
        studentMap = new HashMap<>();

    }

    public StudentManager(HashMap<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public void addStudent() {
        System.out.println("ID is:");
        String id = sc.nextLine();
        System.out.println("Name is:");
        String name = sc.nextLine();
        System.out.println("Age is:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Address is:");
        String address = sc.nextLine();
        Student student = new Student(id, name, age, address);
        studentMap.put(student.getIdStudent(), student);
    }

    public void display() {
        Set<String> keys = studentMap.keySet();
        for (String key : keys) {
            System.out.println(studentMap.get(key));
        }
    }

    public String checkByID() {
        Set<String> keys = studentMap.keySet();
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        Student st = studentMap.get(id);
        for (String key : keys) {
            if (key.equals(id)) {
                return key;
            }
        }
        return null;
    }

    public void findByID() {
        String result = checkByID();
        if (result == null) {
            System.out.println("Can't find this ID");
        } else {
            System.out.println("Có");
        }
    }

    public void findByName() {
        String result = checkByName();
        if (result == null) {
            System.out.println("Nothing!");
        } else {
            System.out.println(studentMap.get(result));
        }

    }

    public String checkByName() {
        Set<String> keys = studentMap.keySet();
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        for (String key : keys) {
            if (studentMap.get(key).getName().equals(name)) {
                return key;
            }
        }
        return null;
    }

    public void deleteByID() {
        String result = checkByID();
        if (result != null) {
            studentMap.remove(result);
        } else {
            System.out.println("Nothing!");
        }
    }
    public void deleteByName() {
        String result = checkByName();
        if (result == null) {
            System.out.println("No have this name");
        } else {
            studentMap.remove(result);
        }
    }

    public void editByName() {
        String result = checkByName();
        if (result == null) {
            System.out.println("No this name");
        } else {
            Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
            List<Map.Entry<String, Student>> listEntries = new ArrayList<>(entries);
            for (Map.Entry<String, Student> entry : listEntries) {
                if (entry.getKey() == result) {
                    editInformation(entry.getValue());
                }
            }
        }
    }

    public void editInformation(Student a) {
        System.out.println("Name is");
        String name = sc.nextLine();
        if (name != null) {
            a.setName(name);
        }
        System.out.println("Age is");
        int age = sc.nextInt();
        sc.nextLine();
        if (age != 0) {
            a.setAgeStudent(age);
        }
        System.out.println("Address is :");
        String address = sc.nextLine();
        if (address != null) {
            a.setAddress(address);
        }
    }

    public void sortByName() {
        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        List<Map.Entry<String, Student>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Student>>() {
            @Override
            public int compare(Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        });
        LinkedHashMap<String, Student> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String, Student> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.studentMap = sortedstudentMap;
    }

    public void sortByAge() {
        Set<Map.Entry<String, Student>> entries = studentMap.entrySet();
        List<Map.Entry<String, Student>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Student>>() {
            @Override
            public int compare(Map.Entry<String, Student> o1, Map.Entry<String, Student> o2) {
                return o1.getValue().getAgeStudent() - o2.getValue().getAgeStudent();
            }
        });
        LinkedHashMap<String, Student> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String, Student> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.studentMap = sortedstudentMap;
    }


}