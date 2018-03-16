package com.didactapp.controllers.v1;

import com.didactapp.server.api.v1.model.BookDTO;
import com.didactapp.server.controllers.v1.BookController;
import com.didactapp.server.services.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookControllerTest {

    private static final String TITLE = "Joe";
    private static final String COVER_URL = "www.google.com";
    private static final String THUMBNAIL_URL = "www.facebook.com";
    private static final String TAG_LINE = "stum";
    private static final String DESCRIPTION = "blah blah";
    private static final long ID_1 = 1L;
    private static final long ID_2 = 2L;
    private static final int VERSION = 1;
    private static final int PUBLISHED_DATE = 1024484393;
    private static final int REVISION_DATE = 1024484553;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

    }

    @Test
    public void testListBooks() throws Exception {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setTitle(TITLE);
        bookDTO1.setBookId(ID_1);
        bookDTO1.setCoverUrl(COVER_URL);
        bookDTO1.setDescription(DESCRIPTION);
        bookDTO1.setPublishedDate(PUBLISHED_DATE);
        bookDTO1.setRevisionDate(REVISION_DATE);
        bookDTO1.setTagLine(TAG_LINE);
        bookDTO1.setThumbnailUrl(THUMBNAIL_URL);
        bookDTO1.setVersion(VERSION);


        BookDTO bookDTO2 = new BookDTO();
        bookDTO2.setTitle(TITLE);
        bookDTO2.setBookId(ID_2);
        bookDTO2.setCoverUrl(COVER_URL);
        bookDTO2.setDescription(DESCRIPTION);
        bookDTO2.setPublishedDate(PUBLISHED_DATE);
        bookDTO2.setRevisionDate(REVISION_DATE);
        bookDTO2.setTagLine(TAG_LINE);
        bookDTO2.setThumbnailUrl(THUMBNAIL_URL);
        bookDTO2.setVersion(VERSION);

        List<BookDTO> books = Arrays.asList(bookDTO1, bookDTO2);

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/v1/books/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.books", hasSize(2)));
    }

    @Test
    public void testGetByNameBooks() throws Exception {
        BookDTO bookDTO1 = new BookDTO();
        bookDTO1.setTitle(TITLE);
        bookDTO1.setBookId(ID_1);
        bookDTO1.setCoverUrl(COVER_URL);
        bookDTO1.setDescription(DESCRIPTION);
        bookDTO1.setPublishedDate(PUBLISHED_DATE);
        bookDTO1.setRevisionDate(REVISION_DATE);
        bookDTO1.setTagLine(TAG_LINE);
        bookDTO1.setThumbnailUrl(THUMBNAIL_URL);
        bookDTO1.setVersion(VERSION);

        when(bookService.getBookByBookId(anyLong())).thenReturn(bookDTO1);

        mockMvc.perform(get("/api/v1/categories/Jim")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.book_id", equalTo(ID_1)));
    }
}