package k25.vk2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import k25.vk2.domain.Friend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FriendController {

    private static List<Friend> friendList = new ArrayList<Friend>();

    static {
        friendList.add(new Friend("Pekka", "Virtanen"));
        friendList.add(new Friend("Matti", "Meikäläinen"));
        friendList.add(new Friend("Liisa", "Virtanen"));
        friendList.add(new Friend("Maikki", "Mallevaara"));
    }

    @GetMapping("/friendlist")
    public String showFriends(Model model) {
        model.addAttribute("friends", friendList);
        return "friendList";
    }

    @RequestMapping("/addfriend")
    public String addFriend(Model model) {
        model.addAttribute("friend", new Friend());
        return "friendForm";
    }

    @PostMapping("/saveFriend")
    public String saveFriend(Friend friend) {
        friendList.add(friend);
        return "redirect:/friendlist";
    }

}
