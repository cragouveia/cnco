package br.com.quantati.cnco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by carlos on 07/06/17.
 */
@Controller
public class RedirectController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/shortlink/{link1}/{link2}")
    public ResponseEntity generateLink(@PathVariable("link1") String link1,@PathVariable("link2") String link2) throws IOException {
        URL url = new URL("http://cncopt.com/w/" + link1 + link2);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/plain");
        conn.setDoOutput(true);
        System.out.println("Link: " + link1 + link2);

        String link = "";

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        for (int c = in.read(); c != -1; c = in.read()) {
            link += (char) c;
        }

        return  ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .body("http://cncopt.com/" + link.trim());
    }

}
