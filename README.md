# book_spring

# book_spring
# thwo-bookshelf

## Workshop

### Step 0:

GET: hello {name}! 

via [Spring Web MVC DispatcherServlet](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-servlet).

### Step 1:

// given

GET: show all books in index page.

// when

// then

implement `fetch book details` functionality.

### Step 2:

// given

a ready-to-wear `form` for book information.

// when

// then

implement `create new book` functionality.

### Step 3:

- option 1: Edit / Delete / ...
- option 2: return data with JSON format => split front-end & back-end


## Extendibility

- What's Spring IoC & DI?
- Service interface => different implementation
- Data Repository


## 我的一点小结，可能有些理解错误的地方

1.@controller放在类名前

2.@Autowired注释的变量bookService不赋初值

3.注释@RequestMapping(value = "/", method = RequestMethod.GET)中的value的值为/,

  表示这个地方是开始，类似于首页吧......
  
  当value = "book/{isbn}",表示在页面上进行了啥操作，得到了一个url:book/xxx, 
  
  在函数中，如果value把某个东东用花括号括起来了，表示它将被作为参数传到函数中，那么在函数传参时用@PathVariable标记这个东东

4.当需要把后台参数传到一个页面并显示时，函数返回类型为ModelAndView

-	a.new一个ModelMap对象model  ModelMap model = new ModelMap();

-	b.model.put("books", bookService.findAll()); 把bookService.findAll()的结果放到一个对象中books中，

-   在对应的页面中，通过${books}获取这个对象，花括号中的books必须与model.put("",xxxx)中的books一毛一样;

-	c.return new ModelAndView("books",model); 把b中搞好的model放到books.html这个页面中，

-   第一个参数就是表示xxx.html或者jsp之类的页面吧......然后就愉快的把数据在这个页面显示出来啦;




##???

页面上的数据怎么到后台的倒腾半天也没弄明白。。

比如saveBook(Book book)的参数book怎么来的，实在没弄明白就只能复制粘贴那个一毛一样的页面代码过来用了。。。。





