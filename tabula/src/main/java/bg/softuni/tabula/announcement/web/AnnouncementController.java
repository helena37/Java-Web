package bg.softuni.tabula.announcement.web;

import bg.softuni.tabula.announcement.service.AnnouncementService;


@AllArgsConstructor
@Controller
@RequestMapping("/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    //TODO: Role user
    @GetMapping
    public String announcement(Model model) {
        model.addAttribute("announcements", announcementService.findAll());
        return "announcement/announcements";
    }
}
