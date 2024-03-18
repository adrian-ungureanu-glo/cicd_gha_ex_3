package com.adrian.gha.addsampleapi;

import org.springframework.stereotype.Service;

@Service
class AddService {

    /**
     * Add two numbers
     * 
     * @param a
     * @param b
     * @return the sum of a and b
     */
    int add(int a, int b) {
        return a + b;
    }

}
