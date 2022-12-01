package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookCode;
import com.example.demo.service.IBookCodeService;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookCodeService iBookCodeService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id).get();
        model.addAttribute("book", book);
        return "book/borrow";
    }

    @PostMapping("/borrow")
    public String borrow(Book book, RedirectAttributes redirectAttributes) {
        int oderCode = (int) (Math.random() * (99999 - 10000)) + 10000;
        BookCode bookCode = new BookCode(oderCode, book, true);
        iBookCodeService.save(bookCode);
        iBookService.removeById(book.getId());
        redirectAttributes.addFlashAttribute("mess", "mượn thành công");
        redirectAttributes.addFlashAttribute("mess1", "bạn đã mượn cuốn: " + book.getBookName() + " ,mã mượn sách của bạn là " + oderCode + " .Hãy giữ lại mã này khi trả sách");
        return "redirect:/book";
    }

    @GetMapping("/pay/{id}")
    public String pay(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id).get();
        model.addAttribute("book", book);
        return "book/pay";
    }

    @PostMapping("/pay")
    public String pay(Book book, RedirectAttributes redirectAttributes, int bookCode, Model model) {
        if (iBookCodeService.isCheck(bookCode)) {
            iBookService.addById(book.getId());
            redirectAttributes.addFlashAttribute("mess", "trả thành công");
            redirectAttributes.addFlashAttribute("mess1", "cảm ơn bạn và hẹn gặp lại");
            return "redirect:/book";
        }
        model.addAttribute("book", book);
        model.addAttribute("mess", "mã không đúng,xin nhập lại");
        return "book/pay";
    }
}
