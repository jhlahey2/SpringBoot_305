package seb.com.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
        Actor actor=new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");
        Set<Actor> actors=new HashSet<Actor>();
        actors.add(actor);
        Movie movie=new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis....");

        Set<Movie> movies=new HashSet<Movie>();
        movies.add(movie);
        actor.setMovies(movies);
        actorRepository.save(actor);
        movie.setCast(actors);
        movieRepository.save(movie);
        model.addAttribute("actors",actorRepository.findAll());

        return "index";
    }

    public void data(Set<Movie> movies,Set<Actor> actors){


    }
}
