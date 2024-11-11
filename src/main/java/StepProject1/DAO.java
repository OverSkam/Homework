//package StepProject1;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//interface DAO<A> {
//    public void save();
//    default void update(A a) throws IOException {
//        throw new IllegalArgumentException("TODO");
//    }
//    default void delete(Long id) throws IOException {
//        throw new IllegalArgumentException("TODO");
//    }
//    default Optional<A> load(long id) {
//        throw new IllegalArgumentException("TODO");
//    }
//    default List<A> loadAll() {
//        throw new IllegalArgumentException("TODO");
//    }
//}
