package info.movietrash.cinemabase.service.impl;

//
//@Service
//@RequiredArgsConstructor
//public class GenreServiceImpl implements GenreService {

//    @Value("${themoviedb.ord.api-key}")
//    private String apiKey;
//    @Value("${themoviedb.ord.scheme}")
//    private String scheme;
//    @Value("${themoviedb.ord.host}")
//    private String host;
//
//    private final GenreRepository genreRepository;
//    private final RestTemplate restTemplate;
//    private final ObjectMapper objectMapper;
//    private final static String JSON_NODE_STR = "results";
//
//    @Override
//    public void reloadData() {
//        URI uri = UriComponentsBuilder.newInstance()
//                .scheme(scheme)
//                .host(host)
//                .path("/3/movie/popular")
//                .queryParam("api_key", apiKey)
//                .build()
//                .toUri();
//
//        RequestEntity request = new RequestEntity(HttpMethod.GET, uri);
//        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
//        String moviesJson = response.getBody();
//
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        JsonNode responseBody = objectMapper.readTree(moviesJson);
//        JsonNode resultsMassive = responseBody.path(JSON_NODE_STR);
//        List<MovieDto> jsonToMoviesList = objectMapper.readValue(resultsMassive.toString(), new TypeReference<List<MovieDto>>() {
//        });
//    }
//}
