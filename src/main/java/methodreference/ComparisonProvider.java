package methodreference;

/**
 * @Author ryan.song
 * @Date 2019/2/12
 **/
public class ComparisonProvider {

    public int compareByName(Person a, Person b){
        return a.getName().compareTo(b.getName());
    }

    public int compareByAge(Person a, Person b){
        return a.getAge() - b.getAge();
    }

}
