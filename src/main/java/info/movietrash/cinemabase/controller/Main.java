package info.movietrash.cinemabase.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.movietrash.cinemabase.dto.MovieDto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String str = "{\n" +
                "  \"page\": 1,\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/fNG7i7RqMErkcqhohV2a6cV1Ehy.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 603,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix\",\n" +
                "      \"overview\": \"Set in the 22nd century, The Matrix tells the story of a computer hacker who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth.\",\n" +
                "      \"popularity\": 53.56,\n" +
                "      \"poster_path\": \"/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg\",\n" +
                "      \"release_date\": \"1999-03-30\",\n" +
                "      \"title\": \"The Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.1,\n" +
                "      \"vote_count\": 19133\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/sDxCd4nt3eR4qOCW1GoD0RabQtq.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        12,\n" +
                "        28,\n" +
                "        53,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 604,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Reloaded\",\n" +
                "      \"overview\": \"Six months after the events depicted in The Matrix, Neo has proved to be a good omen for the free humans, as more and more humans are being freed from the matrix and brought to Zion, the one and only stronghold of the Resistance.  Neo himself has discovered his superpowers including super speed, ability to see the codes of the things inside the matrix and a certain degree of pre-cognition. But a nasty piece of news hits the human resistance: 250,000 machine sentinels are digging to Zion and would reach them in 72 hours. As Zion prepares for the ultimate war, Neo, Morpheus and Trinity are advised by the Oracle to find the Keymaker who would help them reach the Source.  Meanwhile Neo's recurrent dreams depicting Trinity's death have got him worried and as if it was not enough, Agent Smith has somehow escaped deletion, has become more powerful than before and has fixed Neo as his next target.\",\n" +
                "      \"popularity\": 34.886,\n" +
                "      \"poster_path\": \"/8xEVAe84zlL9rkfYT6dZXero4KK.jpg\",\n" +
                "      \"release_date\": \"2003-05-15\",\n" +
                "      \"title\": \"The Matrix Reloaded\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 7791\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/t9dumNakkt6yL9wreEp35T4Lwny.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        12,\n" +
                "        28,\n" +
                "        53,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 605,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Revolutions\",\n" +
                "      \"overview\": \"The human city of Zion defends itself against the massive invasion of the machines as Neo fights to end the war at another front while also opposing the rogue Agent Smith.\",\n" +
                "      \"popularity\": 32.537,\n" +
                "      \"poster_path\": \"/fgm8OZ7o4G1G1I9EeGcb85Noe6L.jpg\",\n" +
                "      \"release_date\": \"2003-11-03\",\n" +
                "      \"title\": \"The Matrix Revolutions\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 6990\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        878,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 624860,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Resurrections\",\n" +
                "      \"overview\": \"The fourth installment in The Matrix franchise. Plot unknown.\",\n" +
                "      \"popularity\": 20.146,\n" +
                "      \"poster_path\": \"/aLs8CRWr6mXTi7fTUzm5p66NXo7.jpg\",\n" +
                "      \"release_date\": \"2021-12-15\",\n" +
                "      \"title\": \"The Matrix Resurrections\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 0,\n" +
                "      \"vote_count\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/lBdXACywnLwKUZmZkZ87djDQBeV.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        99\n" +
                "      ],\n" +
                "      \"id\": 14543,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Revisited\",\n" +
                "      \"overview\": \"The film goes behind the scenes of the 1999 sci-fi movie The Matrix.\",\n" +
                "      \"popularity\": 16.59,\n" +
                "      \"poster_path\": \"/fNG2JOskhQnttmAaj2knM5h59Io.jpg\",\n" +
                "      \"release_date\": \"2001-11-19\",\n" +
                "      \"title\": \"The Matrix Revisited\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 136\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 51767,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Sexual Matrix\",\n" +
                "      \"overview\": \"\\\"Sexual Matrix\\\" is about a matrix that is sexual. A horny professor decides to ask his students all about their sexual fantasies. Of course he does. So while they're describing their wildest dreams, he plugs them into his matrix machine and it lets them live out their fantasies. It seems so real! Mia Zottoli shows up to assist the professor in his quest to know what turns the whole campus on\",\n" +
                "      \"popularity\": 10.895,\n" +
                "      \"poster_path\": \"/vmhBIPKyYCWlp2PrIIc6EXZlP9Z.jpg\",\n" +
                "      \"release_date\": \"2000-04-01\",\n" +
                "      \"title\": \"Sexual Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        99\n" +
                "      ],\n" +
                "      \"id\": 591955,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Reloaded Revisited\",\n" +
                "      \"overview\": \"The making of The Matrix Reloaded:  Go to the middle movies furthest reaches via five documentary paths revealing 21 featurettes\",\n" +
                "      \"popularity\": 12.56,\n" +
                "      \"poster_path\": \"/gb7C4oRzYWXWCuZMR1cwtHa53Pz.jpg\",\n" +
                "      \"release_date\": \"2004-12-07\",\n" +
                "      \"title\": \"The Matrix Reloaded Revisited\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.3,\n" +
                "      \"vote_count\": 11\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        99\n" +
                "      ],\n" +
                "      \"id\": 217056,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Matrix of Evil\",\n" +
                "      \"overview\": \"is a dynamic 2 hour video featuring some of the most informed minds in the world today who expose the latest revelations of the New World Order's agenda in shocking detail.\",\n" +
                "      \"popularity\": 9.537,\n" +
                "      \"poster_path\": \"/A2kExZKGqluSZMO4BiilAfs2axG.jpg\",\n" +
                "      \"release_date\": \"2003-01-01\",\n" +
                "      \"title\": \"Matrix of Evil\",\n" +
                "      \"video\": true,\n" +
                "      \"vote_average\": 6.8,\n" +
                "      \"vote_count\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/5nxDn3mrdmeUHJOZi1Wfqya8Vji.jpg\",\n" +
                "      \"genre_ids\": [\n" +
                "        99,\n" +
                "        878,\n" +
                "        27\n" +
                "      ],\n" +
                "      \"id\": 696109,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"A Glitch in the Matrix\",\n" +
                "      \"overview\": \"Are we in fact living in a simulation? This is the question postulated, wrestled with, and ultimately argued for through archival footage, compelling interviews with real people shrouded in digital avatars, and a collection of cases from some of our most iconoclastic figures in contemporary culture.\",\n" +
                "      \"popularity\": 10.802,\n" +
                "      \"poster_path\": \"/cb6gSLxzDLw2wCew0myZunVlsST.jpg\",\n" +
                "      \"release_date\": \"2021-02-05\",\n" +
                "      \"title\": \"A Glitch in the Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.3,\n" +
                "      \"vote_count\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        99,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 221495,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Recalibrated\",\n" +
                "      \"overview\": \"The making of Matrix Revolutions, The (2003) is briefly touched on here in this documentary. Interviews with various cast and crew members inform us how they were affected by the deaths of Gloria Foster and Aaliyah, and also delve into the making of the visual effects that takes up a lot of screen time. Written by Rhyl Donnelly\",\n" +
                "      \"popularity\": 6.539,\n" +
                "      \"poster_path\": \"/gRni1Q651AZPnLqZczmahiIxG0s.jpg\",\n" +
                "      \"release_date\": \"2004-04-06\",\n" +
                "      \"title\": \"The Matrix Recalibrated\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.7,\n" +
                "      \"vote_count\": 30\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        99\n" +
                "      ],\n" +
                "      \"id\": 26214,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The American Matrix - Age Of Deception\",\n" +
                "      \"overview\": \"A shocking new 2 hour film by B.A. Brooks. This 2010 release is a follow up to \\\"The Decline And Fall Of America\\\" which was released in 2008. \\\"The American Matrix - Age Of Deception\\\" details news items that all people should be aware of such as the economic collapse of The United States and the formation of the a New World Order. See what has really been going on in America today.\",\n" +
                "      \"popularity\": 9.27,\n" +
                "      \"poster_path\": null,\n" +
                "      \"release_date\": \"2010-01-01\",\n" +
                "      \"title\": \"The American Matrix - Age Of Deception\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5,\n" +
                "      \"vote_count\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        14,\n" +
                "        27,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 259464,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"V-World Matrix\",\n" +
                "      \"overview\": \"Two friends take a cyber vacation to experience a world where they can act out their virtual fantasies! They soon realize they've entered a virtual free-for-all. Forbidden fantasies and desires suddenly appear in the form of the even deadlier \\\"dark woman\\\". All the players now end up in a cyber battle for their lives, and sanity, against a beautiful virtual hunter who has one killer fixation - winning the deadly game they started!\",\n" +
                "      \"popularity\": 2.491,\n" +
                "      \"poster_path\": null,\n" +
                "      \"release_date\": \"1999-01-01\",\n" +
                "      \"title\": \"V-World Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 0,\n" +
                "      \"vote_count\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        9648,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 129399,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Time Matrix\",\n" +
                "      \"overview\": \"In the near future, police detective Richard Manning is investigating the most difficult case of his career – the seemingly impossible locked room murder of a wealthy property investor. The more Richard investigates, the more complex the case seems to become. He soon realizes his own future and survival depend on him solving everything – and quickly.\",\n" +
                "      \"popularity\": 3.599,\n" +
                "      \"poster_path\": \"/3pT6TI22UbIckjoMu05tO2mkLYW.jpg\",\n" +
                "      \"release_date\": \"2013-01-01\",\n" +
                "      \"title\": \"Time Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 4.3,\n" +
                "      \"vote_count\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        16,\n" +
                "        878,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"id\": 33322,\n" +
                "      \"original_language\": \"ja\",\n" +
                "      \"original_title\": \"アミテージ・ザ・サード POLY-MATRIX\",\n" +
                "      \"overview\": \"Ross Sylibus is assigned to a police unit on a Martian colony, to find that women are being murdered by a psychotic named D'anclaude. He is assigned a very unorthodox partner named Naomi Armitage, who seems to have links to the victims. To stir things up more, every victim is found to be an illegally made third-generation android.\",\n" +
                "      \"popularity\": 5.703,\n" +
                "      \"poster_path\": \"/7sUCRdjGe7VggDCGIHywfguYdAK.jpg\",\n" +
                "      \"release_date\": \"1996-06-25\",\n" +
                "      \"title\": \"Armitage III: Poly Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"vote_count\": 34\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        99,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 684731,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Reloaded: Pre-Load\",\n" +
                "      \"overview\": \"This making-of piece offers the standard mix of movie snippets, behind the scenes materials, and interviews from cast and crew on the making of the film.\",\n" +
                "      \"popularity\": 5.271,\n" +
                "      \"poster_path\": \"/zkpzfTyF7BjadH1PZKlC6kueWXf.jpg\",\n" +
                "      \"release_date\": \"2003-10-14\",\n" +
                "      \"title\": \"The Matrix Reloaded: Pre-Load\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"vote_count\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        99\n" +
                "      ],\n" +
                "      \"id\": 503880,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Matrix Revolutions Revisited\",\n" +
                "      \"overview\": \"The making of The Matrix Revolutions:\\r The cataclysmic final confrontation chronicled through six documentary pods revealing 28 featurettes\",\n" +
                "      \"popularity\": 5.633,\n" +
                "      \"poster_path\": \"/61ASnmqvzpuz9VEfFElo3e2nIft.jpg\",\n" +
                "      \"release_date\": \"2004-12-07\",\n" +
                "      \"title\": \"The Matrix Revolutions Revisited\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 8.2,\n" +
                "      \"vote_count\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        53,\n" +
                "        28,\n" +
                "        16,\n" +
                "        878,\n" +
                "        12\n" +
                "      ],\n" +
                "      \"id\": 21769,\n" +
                "      \"original_language\": \"ja\",\n" +
                "      \"original_title\": \"アミテージ・ザ・サード DUAL-MATRIX\",\n" +
                "      \"overview\": \"Naomi Armitage and Ross Sylibus have changed their names and live with their daughter Yoko as a happy and normal family on Mars — until an android riot breaks out at an anti-matter plant on Earth.\",\n" +
                "      \"popularity\": 3.724,\n" +
                "      \"poster_path\": \"/p5nd9VPKxpow5MFAQfZy2DEatPI.jpg\",\n" +
                "      \"release_date\": \"2002-03-22\",\n" +
                "      \"title\": \"Armitage: Dual Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"vote_count\": 32\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        99,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"id\": 684431,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Making 'The Matrix'\",\n" +
                "      \"overview\": \"A promotional making-of documentary for the film Matrix, The (1999) that devotes its time to explaining the digital and practical effects contained in the film. This is very interesting, seeing as how they're giving away the cinematic secrets that they created solely for the this movie, that have now been spoofed and referenced in countless other films.\",\n" +
                "      \"popularity\": 2.034,\n" +
                "      \"poster_path\": \"/m2yIfRJYwpCgHON1Ig1pNKMWTxp.jpg\",\n" +
                "      \"release_date\": \"1999-09-21\",\n" +
                "      \"title\": \"Making 'The Matrix'\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7,\n" +
                "      \"vote_count\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [],\n" +
                "      \"id\": 555879,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Matrix\",\n" +
                "      \"overview\": \"The film is composed of receding planes in a landscape: a back garden and the houses beyond. The wooden lattice fence, visible in the image, marks the border between enclosed and open, private and public space, and forms both a fulcrum for the work and a formal grid by which the shots are framed and organised.\",\n" +
                "      \"popularity\": 1.422,\n" +
                "      \"poster_path\": \"/AfFD10ZqEx2vkxM2yvRZkybsGB7.jpg\",\n" +
                "      \"release_date\": \"1998-12-31\",\n" +
                "      \"title\": \"Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 0,\n" +
                "      \"vote_count\": 0\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": null,\n" +
                "      \"genre_ids\": [\n" +
                "        99\n" +
                "      ],\n" +
                "      \"id\": 274866,\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Roots of the Matrix\",\n" +
                "      \"overview\": \"Disc 8 of 10 of 'The Matrix: Ultimate Edition': Probe the philosophical and technological inspirations of The Matrix Trilogy through two insightful documentaries:  - Return to Source: Philosophy &amp; The Matrix documentary – Scholars, philosophers and theorists deconstruct the intellectual underpinnings of the trilogy  - The Hard Problem: The Science Behind the Fiction documentary – Is the notion of a real Matrix plausible? An investigation of the technologies that inspire the metaphor of the Matrix.\",\n" +
                "      \"popularity\": 4.182,\n" +
                "      \"poster_path\": \"/qmOtnpPihV3Wj6ukpiNIgzo4Ax7.jpg\",\n" +
                "      \"release_date\": \"2004-12-07\",\n" +
                "      \"title\": \"The Roots of the Matrix\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.5,\n" +
                "      \"vote_count\": 2\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total_pages\": 4,\n" +
                "  \"total_results\": 72\n" +
                "}";


        //getting whole json string
        JSONObject jsonObj = new JSONObject(str);
//extracting data array from json string
        JSONArray ja_data = jsonObj.getJSONArray("results");
        int length = jsonObj.length();
        for(int i=0; i<length; i++) {


            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            List<MovieDto> jsonToMoviesList = objectMapper.readValue(str, new TypeReference<List<MovieDto>>() {
            });
            jsonToMoviesList.forEach(System.out::println);
        }

    }
}
