package com.example.service;

import com.example.dto.DTOBoard;
import com.example.entity.EntityBoard;
import com.example.entity.EntityUser;
import com.example.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBoard {

    @Autowired
    BoardRepository BoardRepo;

    public void Join(DTOBoard board) {
        System.out.println(board.title);
        System.out.println(board.contents);
        System.out.println(board.author);
        System.out.println(board.date);

        BoardRepo.save(board.ToEntity());
    }



    public Iterable<EntityBoard> getAllBoard() {
        return BoardRepo.findAll();
    }

}
