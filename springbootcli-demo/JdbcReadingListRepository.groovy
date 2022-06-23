@Repository
class JdbcReadingListRepository implements ReadingListRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    List<Book> findByReader(String reader) {
        jdbcTemplate.query(
                "select id, reader, isbn, title, author, description from Book where reader=?",
                {
                    rs, row ->
                        new Book(
                                id: rs.getLong(1),
                                reader: rs.getString(2),
                                isbn: rs.getString(3),
                                title: rs.getString(4),
                                author: rs.getString(5),
                                description: rs.getString(6)
                        )
                } as RowMapper,
                reader // RowMapper 闭包
        )
    }

    void save(Book book) {
        jdbcTemplate.update(
                "insert into Book (reader, isbn, title, author, description) values(?,?,?,?,?)",
                book.reader,
                book.isbn,
                book.title,
                book.author,
                book.description
        )
    }
}