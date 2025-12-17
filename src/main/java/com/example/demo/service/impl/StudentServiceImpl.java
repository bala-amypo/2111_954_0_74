@Service
public class StudentServiceImpl implements StudentService{
      private final Map<Long,Student>store=new Hashmap<>();
      private long counter=1;
      @Override
      public Student insertStudent(Student st){
        st.setId(counter++);
        store.put(st.getId(),st);
        return st;
      }
      @Override 
      public List<Student
}
