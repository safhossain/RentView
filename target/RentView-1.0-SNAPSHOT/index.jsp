<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ryerson.rentview.Helper.MemberInfo"%>
<!DOCTYPE html>
<html>
    <head>
        <title>RentView</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
    </head>
    <header>
        <nav>
            <button id="home">Home</button>
            <button id="genres">Genres</button>
            <input type="search" id="movie-search" placeholder="Search...">
            <% 
                MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
                if (memberInfo != null) {
            %>
                <button id="profile">Profile</button>
                <a href="logout.jsp">Logout</a>
            <% } else { %>
                <a href="login.jsp">Login</a>
            <% } %>
        </nav>
    </header>
    <body>
        <section id="featured">
            <h2>ON SALE NOW</h2>
            <div class="movie-poster">
                <img src="resources/lotr.jpg" alt="Lord of the Rings" width="270" height="400">
            </div>
            <div class="movie-poster">
                <img src="resources/harry_potter.jpg" alt="Harry Potter" width="270" height="400">
            </div>
            <div class="movie-poster">
                <img src="resources/little_women.jpg" alt="Women Little" width="270" height="400">
            </div>
        </section>
        
        <section id="scrolling-movies">
            <div class="scroll-container">                
                <div class="movie-poster-small">
                    <img src="resources/home_alone.jpg" alt="Home Alone" width="135" height="200">
                </div>
                <div class="movie-poster-small">
                    <img src="resources/nemo.jpg" alt="Nemo" width="135" height="200">
                </div>
                <div class="movie-poster-small">
                    <img src="resources/forrest_gump.jpg" alt="Forrest Gump" width="135" height="200">
                </div>
                <div class="movie-poster-small">
                    <img src="resources/toy_story.jpg" alt="Toy Story" width="135" height="200">
                </div>                
            </div>
        </section>
        
        <footer>
            <nav>
                <button onclick="window.scrollTo(0, 0);">scroll to top</button>
                <a href="#terms">terms & conditions</a>
                <a href="#about">about us</a>
                <a href="#support">Support</a>
            </nav>
        </footer>
    </body>
</html>
