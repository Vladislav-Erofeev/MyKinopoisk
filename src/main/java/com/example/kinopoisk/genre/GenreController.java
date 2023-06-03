package com.example.kinopoisk.genre;

import com.example.kinopoisk.utils.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;
    private final GenreMapper genreMapper = GenreMapper.INSTANCE;

    @GetMapping("/all")
    public List<GenreDTO> getAll() {
        return genreService.getAll()
                .stream().map(genreMapper::convertToGenreDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GenreDTO getById(@PathVariable("id") long id) throws GenreNotFoundException {
        return genreMapper.convertToGenreDTO(genreService.getById(id));
    }

    @PostMapping("/add")
    public HttpStatus save(@RequestBody NewGenreDTO newGenreDTO) throws GenreAlreadyExistException {
        genreService.save(genreMapper.convertNewGenreDTOToGenre(newGenreDTO));
        return HttpStatus.OK;
    }

    @PatchMapping("/edit/{id}")
    public HttpStatus edit(@PathVariable("id") long id, @RequestBody NewGenreDTO newGenreDTO)
            throws GenreAlreadyExistException {
        Genre genre = genreMapper.convertNewGenreDTOToGenre(newGenreDTO);
        genre.setId(id);
        genreService.save(genre);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") long id) {
        genreService.delete(id);
        return HttpStatus.OK;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> genreNotFound(GenreNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> genreAlreadyExist(GenreAlreadyExistException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
