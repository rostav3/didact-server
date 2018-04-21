package com.didactapp.services;

import com.didactapp.server.api.v1.mapper.BookMapper;
import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.domain.Book;
import com.didactapp.server.repositories.BookRepository;
import com.didactapp.server.services.BookServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    private static final String TITLE = "Joe";
    private static final String COVER_URL = "www.google.com";
    private static final String THUMBNAIL_URL = "www.facebook.com";
    private static final String TAG_LINE = "stum";
    private static final String DESCRIPTION = "blah blah";
    private static final long ID = 1L;
    private static final int VERSION = 1;
    private static final int PUBLISHED_DATE = 1024484393;
    private static final int REVISION_DATE = 1024484553;

    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        bookService = new BookServiceImpl();
        bookService.setBookMapper(BookMapper.INSTANCE);
        bookService.setBookRepository(bookRepository);
    }

    @Test
    public void getAllBooks() {

        //given
        List<Book> categories = Arrays.asList(new Book(), new Book(), new Book());

        when(bookRepository.findAll()).thenReturn(categories);

        //when
        List<BookDTO> categoryDTOS = bookService.getAllBooks();

        //then
        assertEquals(3, categoryDTOS.size());

    }

    @Test
    public void testGetByBookId() {

        //given
        Book book = new Book();
        book.setTitle(TITLE);
        book.setBookId(ID);
        book.setCoverUrl(COVER_URL);
        book.setDescription(DESCRIPTION);
        book.setPublishedDate(PUBLISHED_DATE);
        book.setRevisionDate(REVISION_DATE);
        book.setTagLine(TAG_LINE);
        book.setThumbnailUrl(THUMBNAIL_URL);
        book.setVersion(VERSION);

        when(bookRepository.findByBookId(ID)).thenReturn(book);

        //when
        BookDTO bookDTO = bookService.getBookByBookId(ID);

        //then
        assertEquals(ID, bookDTO.getBookId());
        assertEquals(TITLE, bookDTO.getTitle());
        assertEquals(COVER_URL, bookDTO.getCoverUrl());
        assertEquals(DESCRIPTION, bookDTO.getDescription());
        assertEquals(PUBLISHED_DATE, bookDTO.getPublishedDate());
        assertEquals(REVISION_DATE, bookDTO.getRevisionDate());
        assertEquals(TAG_LINE, bookDTO.getTagLine());
        assertEquals(THUMBNAIL_URL, bookDTO.getThumbnailUrl());
        assertEquals(VERSION, bookDTO.getVersion());
    }
}