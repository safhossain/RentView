<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ryerson.rentview.Helper.MemberInfo"%>
<!DOCTYPE html>
<html>
    <head>
        <title>RentView</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
    </head>
    
    <body>
        <header>
            <nav>
                <form action="index.jsp">
                        <button type="submit">Home</button>
                </form>
                <button id="genres">Genres</button>
                <input type="search" id="movie-search" placeholder="Search...">
                <% 
                    MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
                    if (memberInfo != null) {
                %>
                    <button id="profile">Profile</button>
                    <button id="logout">
                        <a href="logout.jsp">Logout</a>
                    </button>
                <% } else { %>
                    <form action="login.jsp">
                        <button type="submit">Login</button>
                    </form>
                <% } %>
            </nav>
        </header>
        <section id="featured">
            <h2>ON SALE NOW</h2>
            <div class="movie-poster">
                <img src="resources/movie_posters/lord_of_the_rings_fellowship_of_the_ring.jpg" alt="Lord of the Rings" width="270" height="400">
            </div>
            <div class="movie-poster">
                <img src="resources/movie_posters/harry_potter.jpg" alt="Harry Potter" width="270" height="400">
            </div>
            <div class="movie-poster">
                <img src="resources/movie_posters/little_women.jpg" alt="Women Little" width="270" height="400">
            </div>
        </section>
        
        <section id="scrolling-movies">
            <div class="scroll-container">
                <div class="movie-poster-small">
                    <img src="resources/movie_posters/home_alone.jpg" alt="Home Alone" width="135" height="200">
                </div>
                <div class="movie-poster-small">
                    <img src="resources/movie_posters/nemo.jpg" alt="Nemo" width="135" height="200">
                </div>
                <div class="movie-poster-small">
                    <img src="resources/movie_posters/forrest_gump.jpg" alt="Forrest Gump" width="135" height="200">
                </div>
                <div class="movie-poster-small">
                    <img src="resources/movie_posters/toy_story.jpg" alt="Toy Story" width="135" height="200">
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
