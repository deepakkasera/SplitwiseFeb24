package com.example.splitwisefeb24.commnads;

import com.example.splitwisefeb24.controllers.SettleUpController;
import com.example.splitwisefeb24.dtos.SettleUpGroupResponseDto;
import com.example.splitwisefeb24.dtos.SettleUpRequestDto;
import com.example.splitwisefeb24.dtos.SettleUpResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpCommand implements Command {
    private SettleUpController settleUpController;

    public SettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        Long userId = Long.valueOf(words.get(0));
        SettleUpRequestDto requestDto = new SettleUpRequestDto();
        requestDto.setUserId(userId);

        SettleUpResponseDto responseDto = settleUpController.settleUpUser(requestDto);
    }


    //userId settleUp
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equals(CommandKeywords.settleUpCommand);
    }
}
