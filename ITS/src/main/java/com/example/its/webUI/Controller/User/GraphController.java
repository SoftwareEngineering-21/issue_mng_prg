// package com.example.its.webUI.Controller.User;

// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

// @Controller
// public class GraphController {
//     @GetMapping("/graph")
//     public String graph(Model model) {
//         // 초기 데이터를 가져와 모델에 추가

//         String title = "A";
//         model.addAttribute("title", title);

//         double[] initialData = new double[] {70.0, 70.0, 70.0, 40.0, 50.0}; // 예시 함수 이름
//         model.addAttribute("initialData", initialData);
//         return "graph";
//     }

//     @PostMapping("/graph")
//     public String updateGraph(Model model) {
//         System.out.println("category");
//         String title = "My Chart Title";
//         model.addAttribute("title", title);

//         // 카테고리에 해당하는 데이터를 가져와 모델에 추가
//         double[] newData = new double[] {100.0, 100.0, 100.0, 100.0, 100.0}; // 예시 함수 이름
//         model.addAttribute("initialData", newData);

//         return "graph :: chart"; // Ajax로 업데이트하므로 일부분만 업데이트
//     }
// }
