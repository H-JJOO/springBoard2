package org.example.springboard2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("list", service.selBoardList());
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.insBoard(entity);
        if (result == 0) {
//            RedirectAttributes 는 redirect 와 관련되어 있다.
//            reAttr.addAttribute("msg", "글 등록에 실패하였습니다."); // addAttribute 는 쿼리스트링 생성
            reAttr.addFlashAttribute("msg", "글 등록에 실패하였습니다.");//객체로 보내지네?(req.setAttribute 같이, request에 담아서 보내준다.)
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

}
