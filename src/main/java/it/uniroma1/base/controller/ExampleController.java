/*
 * Copyright 2024 Giuseppe Valente<valente.1160073@studenti.uniroma1.it>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.uniroma1.base.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.uniroma1.base.service.RabbitMqProducer;



@Controller
public class ExampleController {

    @Autowired
    private RabbitMqProducer rabbitProducer;

    private static String calculateSHA2Hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = digest.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte hashByte : hashBytes) {
            String hex = Integer.toHexString(0xff & hashByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }


    @GetMapping("/")
    @ResponseBody
    public String index() throws NoSuchAlgorithmException {
        Random random = new Random();
        int randomNumber = random.nextInt();
        String randomNumberAsString = Integer.toString(randomNumber);
        String sha256Hash = calculateSHA2Hash(randomNumberAsString, "SHA-256");
        rabbitProducer.produceMessage("rabbitmq", sha256Hash);
        String result = String.format("You need to see from the terminal and this page the same SHA2 code\n %s", sha256Hash);
        return result;
    }


}
