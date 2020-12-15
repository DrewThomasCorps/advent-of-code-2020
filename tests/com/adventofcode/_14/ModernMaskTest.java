package com.adventofcode._14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModernMaskTest {

    @Test
    void getAllPossibleMasks() {
        ModernMask mask = new ModernMask("XXX");
        assertEquals(8, mask.getAllPossibleMasks().size());
        mask = new ModernMask("1XXX");
        assertEquals(8, mask.getAllPossibleMasks().size());
        List<Mask> masks = mask.getAllPossibleMasks();
        mask = new ModernMask("01XXXX");
        assertEquals(16, mask.getAllPossibleMasks().size());
    }
}