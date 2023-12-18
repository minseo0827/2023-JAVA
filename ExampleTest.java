import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
import java.awt.Insets;

public class ExampleTest extends JFrame implements ActionListener {
    private JPanel panel, panel2, panel3;
    private JLabel[] labels, MainLabel;
    private JButton button1, button2;
    private ImageIcon[] images;
    private int currentIndex;
    private List<Animal> animals;

    public ExampleTest() {
        setTitle("이미지 뷰어");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Rabbit());
        
        
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel3.setLayout(new BorderLayout());

        
        
        labels = new JLabel[10];


        for (int i = 0; i < labels.length; i++) {
        	labels[i] = new JLabel();
            labels[i].setFont(new Font("돋움", Font.BOLD, 18));
            
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 0, 10, 0);
            panel2.add(labels[i], gbc);
        }

        button1 = new JButton("이전 동물");
        button2 = new JButton("다음 동물");
        button1.addActionListener(this);
        button2.addActionListener(this);

        panel.add(button1);
        panel.add(button2);
        panel3.add(panel2, BorderLayout.CENTER);
        panel3.add(panel, BorderLayout.SOUTH);

        add(panel3);


        images = new ImageIcon[3];
        images[0] = new ImageIcon("d://puppy.jpg");
        images[1] = new ImageIcon("d://kitten.jpg");
        images[2] = new ImageIcon("d://rabbit.jpg");
        

        currentIndex = 0;
        updateImage();

       

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            currentIndex = (currentIndex - 1 + images.length) % images.length;
        } else if (e.getSource() == button2) {
            currentIndex = (currentIndex + 1) % images.length;
        }
        updateImage();

    }

    
    private void updateImage() {
        ImageIcon imageIcon = images[currentIndex];
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageIcon.setImage(image);

        JLabel currentLabel = labels[0];
        currentLabel.setIcon(imageIcon);

        Animal currentAnimal = animals.get(currentIndex);
        labels[1].setText("이름: " + currentAnimal.getName());
        labels[2].setText("종류: " + currentAnimal.getSpecies());
        labels[3].setText("나이: " + currentAnimal.getAge()+"살");
        labels[4].setText("특징: " + currentAnimal.getFeatures());
        labels[5].setText("잃어버린 장소: " + currentAnimal.getLostPlace());
        labels[6].setText("연락처: " + currentAnimal.getContact());
        labels[7].setText("현재 상태: " + currentAnimal.Nowstate());
        labels[8].setText("찾은 방법: " + currentAnimal.HowIFound());



        for (int i = 1; i < labels.length; i++) {
            labels[i].setIcon(null);
        }
    }

    
    
    class Animal implements Now{
        private String name;
        private String species;
        private int age;
        private String features;
        private String lostPlace;
        private String contact;

        public Animal(String name, String species, int age, String features, String lostPlace, String contact) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.features = features;
            this.lostPlace = lostPlace;
            this.contact = contact;
        }
        
        
        public String Nowstate() {
            return "동물의 현재 상태";
        }

        public String getName() {
            return name;
        }

        public String getSpecies() {
            return species;
        }

        public int getAge() {
            return age;
        }

        public String getFeatures() {
            return features;
        }

        public String getLostPlace() {
            return lostPlace;
        }

        public String getContact() {
            return contact;
        }
    }

    
    class Dog extends Animal implements Now {
        public Dog() {
            super("기름이", "개, 골든리트리버", 1, "사람을 좋아함, 빨간 옷을 입었음", "00시 00구 00아파트 00공원 놀이터주변", "000-0000-0000");
            //정보 수정 이후 super("기름이", "개, 골든리트리버", 1, "사람을 좋아함, 빨간 목줄을 착용함", "00시 00구 00아파트 00공원 놀이터주변", "000-0000-0000");
        }
        
        public String Nowstate() {
            return "찾았어요";
        }
        
        public String HowIFound() {
            return "자주 산책가던 곳에 있었어요. 계속 이름 부르면서 좋아하는 간식 들고 찾아다니세요.";
        }
        
    }

    class Cat extends Animal implements Now {
        public Cat() {
            super("나비", "고양이, 아메리칸 숏헤어", 2, "사람 무서워함, 귀가 잘 안 들림", "00시 00구 00아파트 101동", "000-1111-1111");
        }
        
        
        public String Nowstate() {
            return "못 찾았어요";
            //정보 수정 후 return "찾았어요";
        }
        
        //찾은 이후
		/*
		 * public String HowIFound() { return
		 * "고양이 화장실을 현관문 앞에 꺼내두세요 애가 잘 가지고 놀던 장난감이나 좋아하는 간식도 같이 둬주세요"; }
		 */
        
        
    }

    class Rabbit extends Animal implements Now {
        public Rabbit() {
            super("막시무스1세", "토끼", 1, "어두운 곳에 있으려함, 덩치가 꽤 큼", "00시 00구 00로 동물병원 근처", "000-2222-2222");
            //정보 수정 후 super("막시무스1세", "토끼", 1, "덩치가 꽤 큼", "00시 00구 00로 동물병원 근처", "000-2222-2222");
        }
        
        public String Nowstate() {
            return "못 찾았어요";
            
        }
        
    }


    interface Now {
        String Nowstate();
        default String HowIFound() {return "없음";}

    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExampleTest();
            }
        });
    }
}