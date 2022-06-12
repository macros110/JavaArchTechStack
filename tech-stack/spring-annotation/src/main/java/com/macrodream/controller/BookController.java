package com.macrodream.controller;

import com.macrodream.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Macros.Zhang
 * @date 6/4/2022 12:32
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
