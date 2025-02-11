package com.example.yarmer.Service;

import com.example.yarmer.Model.Memory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryServiceImpl implements MemoryService  {

    private final List<Memory> memories = List.of(
                new Memory("https://res.cloudinary.com/dvux14dny/image/upload/v1739259266/IMG_6059_gpkoud.jpg", "Gölparkta kahvaltı edişimiz 🫶🏻"),
                new Memory("https://res.cloudinary.com/dvux14dny/image/upload/v1739259264/ae3bc230-32f7-4a41-85b4-cf735bf99ebf_ebazbn.jpg", "İlk buluşmamız ❤️"),
                new Memory("https://res.cloudinary.com/dvux14dny/image/upload/v1739259266/IMG_6291_jekkax.jpg", "burgerbar da yarışmamız 😸️"),
                new Memory("https://res.cloudinary.com/dvux14dny/image/upload/v1739259266/IMG_6222_vlfb0a.jpg", "Silivride buluşmamız o yüksek yerde 🤩"),
                new Memory("https://res.cloudinary.com/dvux14dny/image/upload/v1739259266/IMG_6379_dsac7l.jpg", "İstanbul gezimiz ☀️️")
        );

        public List<Memory> getPaginatedMemories(int page, int size) {
            int startIndex = page * size;
            int endIndex = Math.min(startIndex + size, memories.size());
            return memories.subList(startIndex, endIndex);
        }

        public int getTotalPages(int size) {
            return (int) Math.ceil((double) memories.size() / size);
        }
}