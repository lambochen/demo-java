@Controller
@RequestMapping("/")
class ReadingListController {
    String reader = "Bob"

    @Autowired
    ReadingListRepository readingListRepository

    @RequestMapping(method = RequestMethod.GET)
    def readersBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader)

        if (readingList) {
            model.addAttribute("books", readingList)
        }

        "readingList" // 返回视图名称
    }

    @RequestMapping(method = RequestMethod.POST)
    def addToReadinglist(Book book) {
        book.setReader(reader)

        readingListRepository.save(book)

        "redirect:/" // POST 后重定向
    }
}