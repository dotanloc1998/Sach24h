package com.sinhvien.sach24h;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sinhvien.sach24h.Model.HinhAnhSach;
import com.sinhvien.sach24h.Model.MyDB;
import com.sinhvien.sach24h.Model.NhaXuatBan;
import com.sinhvien.sach24h.Model.Sach;
import com.sinhvien.sach24h.Model.TaiKhoan;
import com.sinhvien.sach24h.Model.TheLoai;


public class MenuFragment extends Fragment {
    Button buttonAdmin, buttonThemCSDL, buttonThongTin;
    MyDB db;
    String taiKhoanDangNhap;
    LinearLayout layoutAdmin, layoutThemCSDL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        AnhXa(view);
        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AdminActivity.class);
                startActivity(intent);
            }
        });
        buttonThemCSDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemCSDL();
                Toast.makeText(getContext(), "Thêm CSDL thành công", Toast.LENGTH_SHORT).show();
            }
        });
        buttonThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (taiKhoanDangNhap.equals("")) {
                    Intent moGiaoDienDangNhap = new Intent(getContext(), DangNhapActivity.class);
                    startActivity(moGiaoDienDangNhap);
                } else {
                    Intent moGiaoDienNguoiDung = new Intent(getContext(), ThongTinNguoiDungActivity.class);
                    startActivity(moGiaoDienNguoiDung);
                }
            }
        });
        return view;
    }

    private void AnhXa(View view) {
        buttonAdmin = view.findViewById(R.id.buttonAdmin);
        buttonThemCSDL = view.findViewById(R.id.buttonThemCSDL);
        buttonThongTin = view.findViewById(R.id.buttonThongTin);
        layoutAdmin = view.findViewById(R.id.layoutAdmin);
        layoutThemCSDL = view.findViewById(R.id.layoutThemCSDL);
        db = new MyDB(getContext());

        taiKhoanDangNhap = db.LayTaiKhoanDangDangNhap();

//        if (!taiKhoanDangNhap.equals("admin")) {
//            layoutAdmin.setVisibility(View.INVISIBLE);
//            layoutThemCSDL.setVisibility(View.INVISIBLE);
//        }
    }

    private void ThemCSDL() {
        //Thêm thể loại
        db.ThemTheLoai(new TheLoai("Viễn tưởng", "HD", "https://i.kinja-img.com/gawker-media/image/upload/s--MrLx7ocP--/c_scale,f_auto,fl_progressive,q_80,w_800/l5luskqeprim7l1llid2.jpg"));
        db.ThemTheLoai(new TheLoai("Chính trị", "HD", "https://endeavors.unc.edu/wp-content/uploads/Politics-Graphic_Final.jpg"));
        db.ThemTheLoai(new TheLoai("Khoa học", "HD", "https://www.asianscientist.com/wp-content/uploads/bfi_thumb/20160627-Grand-Challenges-of-Science-31qtkdbz2aajgveb3em2gw.jpg"));
        db.ThemTheLoai(new TheLoai("Lịch sử", "HD", "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_660,h_382/https://discoverpods.com/wp-content/uploads/2018/12/maps-atlantic-oldtimer-car-compass-vintage-1442539-pxhere.com_-660x382.jpg"));
        db.ThemTheLoai(new TheLoai("Văn học", "HD", "https://1d26q01bh7vg3dctqgnx0671-wpengine.netdna-ssl.com/wp-content/uploads/2017/01/IAFOR-Journal-of-Literature-Librarianship-1100x550.jpg"));
        db.ThemTheLoai(new TheLoai("Thiếu nhi", "HD", "https://d3a1v57rabk2hm.cloudfront.net/5b641de0ac42492e8bfd0ae8aa358746.jpeg"));

        //Thêm nhà xuất bản
        db.ThemNhaXuatBan(new NhaXuatBan("Nhà xuất bản trẻ", "HD"));
        db.ThemNhaXuatBan(new NhaXuatBan("Nhà xuất bản Giáo dục", "HD"));
        db.ThemNhaXuatBan(new NhaXuatBan("Nhà xuất bản Văn Học", "HD"));
        db.ThemNhaXuatBan(new NhaXuatBan("Nhà xuất bản Chính trị Quốc gia", "HD"));
        db.ThemNhaXuatBan(new NhaXuatBan("Nhà xuất bản Phương Đông", "HD"));

        //Thêm sách
        db.ThemSach(new Sach(0, "MẮT BIẾC (TÁI BẢN 2019)", 5, "Nguyễn Nhật Ánh", "2019", "200g", "13 x 20", "Mắt biếc là một tác phẩm được nhiều người bình chọn là hay nhất của nhà văn Nguyễn Nhật Ánh. Tác phẩm này cũng đã được dịch giả Kato Sakae dịch sang tiếng Nhật để giới thiệu với độc giả Nhật Bản.\n" +
                "\n" +
                "“Tôi gửi tình yêu cho mùa hè, nhưng mùa hè không giữ nổi. Mùa hè chỉ biết ra hoa, phượng đỏ sân trường và tiếng ve nỉ non trong lá. Mùa hè ngây ngô, giống như tôi vậy. Nó chẳng làm được những điều tôi ký thác. Nó để Hà Lan đốt tôi, đốt rụi. Trái tim tôi cháy thành tro, rơi vãi trên đường về.”\n" +
                "\n" +
                "… Bởi sự trong sáng của một tình cảm, bởi cái kết thúc buồn, rất buồn khi xuyên suốt câu chuyện vẫn là những điều vui, buồn lẫn lộn… ", "300", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 1, 1, 100, 0));
        db.ThemSach(new Sach(0, "CHO TÔI XIN MỘT VÉ ĐI TUỔI THƠ", 5, "Nguyễn Nhật Ánh", "2018", "200g", "13 x 20", "Trong Cho tôi xin một vé đi tuổi thơ, nhà văn Nguyễn Nhật Ánh mời người đọc lên chuyến tàu quay ngược trở lại thăm tuổi thơ và tình bạn dễ thương của 4 bạn nhỏ. Những trò chơi dễ thương thời bé, tính cách thật thà, thẳng thắn một cách thông minh và dại dột, những ước mơ tự do trong lòng… khiến cuốn sách có thể làm các bậc phụ huynh lo lắng rồi thở phào. Không chỉ thích hợp với người đọc trẻ, cuốn sách còn có thể hấp dẫn và thực sự có ích cho người lớn trong quan hệ với con mình.", "208", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 2, 2, 100, 0));
        db.ThemSach(new Sach(0, "LÀM BẠN VỚI BẦU TRỜI", 5, "Nguyễn Nhật Ánh", "2019", "200g", "13 x 20", "Một câu chuyện giản dị, chứa đầy bất ngờ cho tới trang cuối cùng. Và đẹp lộng lẫy, vì lòng vị tha và tình yêu thương, khiến mắt rưng rưng vì một nỗi mừng vui hân hoan. Cuốn sách như một đốm lửa thắp lên lòng khát khao sống tốt trên đời.\n" +
                "\n" +
                "Viết về điều tốt đã không dễ, viết sao cho người đọc có thể đón nhận đầy cảm xúc tích cực, và muốn được hưởng, được làm những điều tốt dù nhỏ bé... mới thật là khó. Làm bạn với bầu trời của Nguyễn Nhật Ánh đã làm được điều này.", "220", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 3, 3, 100, 0));
        db.ThemSach(new Sach(0, "HÀNH LÝ HƯ VÔ", 5, "Nguyễn Ngọc Tư", "2019", "200g", "13 x 20", "Đó là thứ duy nhất có thể mang theo.\n" +
                "\n" +
                "Vào đúng khi bạn nhận ra có bao nhiêu đồ đạc cũng chẳng lấp nổi biển trong lòng.\n" +
                "\n" +
                "Vào đúng khi bạn có quá nhiều thứ để nhìn nhận lại trước và trong những cuộc chia tay.\n" +
                "\n" +
                "Vào đúng khi bạn hiểu cách những mối quan hệ biến dạng sau mỗi cuộc chuyển dời, nhất là giữa người với người.\n" +
                "\n" +
                "Vào đúng khi bạn biết là mình có thể buông, nhẹ không.\n" +
                "\n" +
                "Hành lý hư vô là tập tản văn mới nhất của nhà văn Nguyễn Ngọc Tư. Đọc nó, người ta khó lòng ngăn cản được nỗi buồn, mà cũng không muốn ngăn cản nỗi buồn bởi cuối dòng chảy cảm xúc ấy là sự đồng cảm, hy vọng và cả dỗ dành.\n" +
                "\n" +
                "Một tập tản văn đẹp, hiền, mộc mạc và sâu lắng chứa đựng tấm lòng của người viết.", "164", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 4, 4, 100, 0));
        db.ThemSach(new Sach(0, "MÌNH NÓI GÌ KHI NÓI VỀ HẠNH PHÚC", 5, "Rosie Nguyễn", "2018", "200g", "14 x 20", "Mình nói gì khi nói về hạnh phúc? là những tâm sự và trải lòng trên hành trình sống và đi, những suy tư về hạnh phúc, về mục đích sống, và thân phận con người. Giọng kể chuyện cứ như thủ thỉ tâm tình, đem lại cảm giác dễ chịu, nhẹ nhàng mà sâu lắng. Và trong những câu chữ đều lấp lánh vẻ đẹp của tình yêu cuộc sống.\n" +
                "\n" +
                "Tác phẩm gồm ba phần chính là Sống, Yêu, Vui với gần 30 bài viết dưới phong cách tự sự nhằm hướng tới những bạn trẻ để các bạn chiêm nghiệm về cuộc sống và hạnh phúc. Ngôn ngữ giản dị gần gũi như chính tâm sự của tác giả với bạn đọc.", "196", "Sách tiếng Việt", "Nhã Nam", "Bìa Mềm", "HD", 5, 5, 100, 0));
        db.ThemSach(new Sach(0, "NGƯỜI LỚN KHÔNG KHÓC", 5, "Hamlet Trương", "2017", "400g", "13 x 20", "Cuốn sách đầy cảm xúc đánh dấu sự trở lại với sở trường bao năm qua của Hamlet Trương trong thể loại tản văn gồm 29 bài viết mới về cuộc sống và tình yêu, hai vấn đề lớn trong cuộc sống của một \"người lớn\". Hamlet Trương không còn gọi độc giả của mình là \"người thương\" nữa, mà thay vào đó là \"người lớn\", khi đã cùng nhau trải qua một hành trình cảm xúc dài hơn 5 năm cùng nhau. \n" +
                "\"Người lớn không khóc\" chưa bao giờ là lời khẳng định chắc nịch về sự mạnh mẽ bởi đâu ai biết mình sẽ rơi lệ khi nào, câu nói này chỉ là lời nhắc nhở cho những ai đang chạm ngõ trưởng thành, rằng người lớn sẽ lựa chọn rơi lệ vì những gì xứng đáng, và ở một ý nghĩa khác, người lớn không khóc vì bao nhiêu nước mắt đã chảy ngược vào tim sau quá nhiều thương tổn.", "138", "Sách tiếng Việt", "Cty Văn Hóa Khánh Thủy", "Bìa Mềm", "HD", 6, 1, 100, 0));
        db.ThemSach(new Sach(0, "KHÓI TRỜI LỘNG LẪY", 5, "Nguyễn Ngọc Tư", "2017", "200g", "13 x 20", "Quá khứ là kỷ niệm ấm áp, còn tương lai là những khát khao. Giữa hai miền thời gian đó, những chuyến dong ruổi, dù ngắn, qua ngóc ngách của làng quê hiện tại, đã giúp nhà văn viết nên những chi tiết hiện thực gây nhói buốt. \"Gáy người thì lạnh\" giống như những lời trần tình (hay tự vấn) của tác giả, đồng thời cũng là chia sẻ đến những ai mong được kết nối với tự nhiên, thèm được thở \"những thứ khí trời bên ngoài cánh cửa\".", "144", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 1, 2, 100, 0));
        db.ThemSach(new Sach(0, "KHÔNG AI QUA SÔNG", 5, "Nguyễn Ngọc Tư", "2016", "250g", "13 x 20", "Không ai qua sông - Tập truyện ngắn mới nhất của Nguyễn Ngọc Tư gợi bạn đọc nhớ đến đến truyện dài Cánh đồng bất tận đã từng gây xôn xao trên văn đàn một thời gian dài. Cũng lấy cảm hứng từ cuộc sống của người dân nông thôn miền Tây, nhưng giờ đây nhân vật của NNT có cái trăn trở của một vùng đất đã dần bị đô thị hóa, con người phải thích ứng với những thứ nhân danh cuộc sống hiện đại nhưng có thể phá nát những rường mối gia đình.", "160", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 2, 3, 100, 0));
        db.ThemSach(new Sach(0, "INFERNO", 5, "Dan Brown", "2013", "282g", "17 x 11", "Harvard professor of symbology Robert Langdon awakens in an Italian hospital, disoriented and with no recollection of the past thirty-six hours, including the origin of the macabre object hidden in his belongings. With a relentless female assassin trailing them through Florence, he and his resourceful doctor, Sienna Brooks, are forced to flee. Embarking on a harrowing journey, they must unravel a series of codes, which are the work of a brilliant scientist whose obsession with the end of the world is matched only by his passion for one of the most influential masterpieces ever written, Dante Alighieri's The Inferno.", "611", "Sách Tiếng Nước Ngoài", "Random House", "Bìa Mềm", "HD", 3, 4, 100, 0));
        db.ThemSach(new Sach(0, "ANGELS AND DEMONS", 5, "Dan Brown", "2009", "700g", "17.0 x 11.0", "World-renowned Harvard symbologist Robert Langdon is summoned to a Swiss research facility to analyze a cryptic symbol seared into the chest of a murdered physicist. What he discovers is unimaginable: a deadly vendetta against the Catholic Church by a centuries-old underground organization -- the Illuminati. Desperate to save the Vatican from a powerful time bomb, Langdon joins forces in Rome with the beautiful and mysterious scientist Vittoria Vetra. Together they embark on a frantic hunt through sealed crypts, dangerous catacombs, deserted cathedrals, and the most secretive vault on earth...the long-forgotten Illuminati lair.", "640", "Sách Tiếng Nước Ngoài", "Grantham Book Services", "Bìa Mềm", "HD", 4, 5, 100, 0));
        db.ThemSach(new Sach(0, "THE DA VINCI CODE", 5, "Dan Brown", "2016", "321g", "12.9 x 19.8", "History professor Robert Langdon receives an urgent late-night phone call while on business in France: the curator of the Louvre in Paris has been brutally murdered inside the museum. Alongside the body, police have found a series of baffling codes and need Langdon's help to decipher them.\n" +
                "\n" +
                "When Langdon and a French cryptologist, Sophie Neveu, begin to sort through the bizarre riddles, they find a trail that leads to the works of the famous artist and inventor Leonardo Da Vinci. As the clues unfold, Langdon and Neveu must decipher the code and quickly assemble the pieces of the puzzle before a stunning historical truth is lost forever .", "448", "Sách Tiếng Nước Ngoài", "Penguin Books", "Bìa Mềm", "HD", 5, 1, 100, 0));
        db.ThemSach(new Sach(0, "THE TITAN'S CURSE: THE GRAPHIC NOVEL", 10, "Rick Riordan", "2013", "300g", "22.8 x 15.2", "A new prophecy leads to a dangerous quest. When Percy receives an urgent distress call from Grover, he immediately prepares for battle. He knows he'll need his powerful demigod allies, Annabeth and Thalia, at his side; his trusty bronze sword, Riptide; and a ride from his mom. The demigods race to the rescue, only to find that Grover has made an important discovery: two new powerful half-bloods, whose parentage is unknown.", "128", "Sách Tiếng Nước Ngoài", "Hachette", "Bìa Mềm", "HD", 6, 2, 100, 0));
        db.ThemSach(new Sach(0, "PERCY JACKSON AND THE BATTLE OF THE LABYRINTH", 15, "Rick Riordan", "2013", "350g", "13 x 20", "Half Boy. Half God. All Hero. Honestly, blowing up another school was the last thing I wanted to do. As the son of a Greek God, I've had my share of near-death disaster - and now my arch enemy Luke wants to invade our camp via an ancient labyrinth. If he succeeds, thousands of bloodthirsty monsters will attack. So it's goodbye sunshine, hello darkness as four of us descend into the terrifying underground and beyond...Rick Riordan is the Mythmaster. The Greek Gods are alive and kicking.", "352", "Sách Tiếng Nước Ngoài", "Penguin Books", "Bìa Mềm", "HD", 1, 3, 100, 0));
        db.ThemSach(new Sach(0, "TWO BY TWO", 5, "Nicholas Sparks", "2017", "240g", "10,8 x 3,5", "A heartwarming, powerful novel about a single father who must discover the true nature of unconditional love after his world is turned upside down--from the world's most beloved author of love stories.", "496", "Sách Tiếng Nước Ngoài", "Hachette", "Bìa Mềm", "HD", 2, 4, 100, 0));
        db.ThemSach(new Sach(0, "THE LAST SONG", 5, "Nicholas Sparks", "2010", "385g", "17 x 10", "Seventeen year old Veronica \"Ronnie\" Miller's life was turned upside-down when her parents divorced and her father moved from New York City to Wrightsville Beach, North Carolina. Three years later, she remains angry and alientated from her parents, especially her father...until her mother decides it would be in everyone's best interest if she spent the summer in Wilmington with him. Ronnie's father, a former concert pianist and teacher, is living a quiet life in the beach town, immersed in creating a work of art that will become the centerpiece of a local church.", "463", "Sách Tiếng Nước Ngoài", "Hachette", "Bìa Mềm", "HD", 3, 5, 100, 0));
        db.ThemSach(new Sach(0, "SAFE HAVEN", 5, "Nicholas Sparks", "2012", "222g", "17.3 x 10.7", "When a mysterious young woman named Katie appears in the small North Carolina town of Southport, her sudden arrival raises questions about her past. Beautiful yet self-effacing, Katie seems determined to avoid forming personal ties until a series of events draws her into two reluctant relationships: one with Alex, a widowed store owner with a kind heart and two young children; and another with her plainspoken single neighbor, Jo. Despite her reservations, Katie slowly begins to let down her guard, putting down roots in the close-knit community and becoming increasingly attached to Alex and his family.", "405", "Sách Tiếng Nước Ngoài", "Hachette", "Bìa Mềm", "HD", 4, 1, 100, 0));
        db.ThemSach(new Sach(0, "THE LUCKY ONE", 5, "Nicholas Sparks", "2012", "300g", "17.0 x 10.4", "In his 14th book, bestselling author Nicholas Sparks tells the unforgettable story of a man whose brushes with death lead him to the love of his life. After U.S. Marine Logan Thibault finds a photograph of a smiling young woman buried in the dirt during his tour of duty in Iraq, he experiences a sudden streak of luck -- winning poker games and even surviving deadly combat. Only his best friend, Victor, seems to have an explanation for his good fortune: the photograph -- his lucky charm. Back home in Colorado, Thibault can't seem to get the woman in the photograph out of his mind and he sets out on a journey across the country to find her.", "400", "Sách Tiếng Nước Ngoài", "Hachette", "Bìa Mềm", "HD", 5, 2, 100, 0));
        db.ThemSach(new Sach(0, "THE ALCHEMIST", 5, "Paulo Coelho", "2006", "140g", "10.4 x 17.2", "A global phenomenon, The Alchemist has been read and loved by over 62 million readers, topping bestseller lists in 74 countries worldwide. Now this magical fable is beautifully repackaged in an edition that lovers of Paulo Coelho will want to treasure forever. Every few decades a book is published that changes the lives of its readers forever. This is such a book - a beautiful parable about learning to listen to your heart, read the omens strewn along life's path and, above all, follow your dreams. Santiago, a young shepherd living in the hills of Andalucia, feels that there is more to life than his humble home and his flock. One day he finds the courage to follow his dreams into distant lands, each step galvanised by the knowledge that he is following the right path: his own. The people he meets along the way, the things he sees and the wisdom he learns are life-changing. With Paulo Coelho's visionary blend of spirituality, magical realism and folklore, The Alchemist is a story with the power to inspire nations and change people's lives.", "195", "Sách Tiếng Nước Ngoài", "Harper Collins", "Bìa Mềm", "HD", 6, 3, 100, 0));
        db.ThemSach(new Sach(0, "ME BEFORE YOU", 5, "Jojo Moyes", "1905", "300g", "19.8 x 3.1", "Lou Clark knows lots of things. She knows how many footsteps there are between the bus stop and home. She knows she likes working in The Buttered Bun tea shop and she knows she might not love her boyfriend Patrick.\n" +
                "\n" +
                "What Lou doesn't know is she's about to lose her job or that knowing what's coming is what keeps her sane.\n" +
                "\n" +
                "Will Traynor knows his motorcycle accident took away his desire to live. He knows everything feels very small and rather joyless now and he knows exactly how he's going to put a stop to that.", "496", "Sách Tiếng Nước Ngoài", "Penguin Books", "Bìa Mềm", "HD", 1, 4, 100, 0));
        db.ThemSach(new Sach(0, "HARRY POTTER VÀ HÒN ĐÁ PHÙ THUỶ", 2, "J.K.Rowling", "2017", "500g", "14 x 20", "Khi một lá thư được gởi đến cho cậu bé Harry Potter bình thường và bất hạnh, cậu khám phá ra một bí mật đã được che giấu suốt cả một thập kỉ. Cha mẹ cậu chính là phù thủy và cả hai đã bị lời nguyền của Chúa tể Hắc ám giết hại khi Harry mới chỉ là một đứa trẻ, và bằng cách nào đó, cậu đã giữ được mạng sống của mình. Thoát khỏi những người giám hộ Muggle không thể chịu đựng nổi để nhập học vào trường Hogwarts, một trường đào tạo phù thủy với những bóng ma và phép thuật, Harry tình cờ dấn thân vào một cuộc phiêu lưu đầy gai góc khi cậu phát hiện ra một con chó ba đầu đang canh giữ một căn phòng trên tầng ba. Rồi Harry nghe nói đến một viên đá bị mất tích sở hữu những sức mạnh lạ kì, rất quí giá, vô cùng nguy hiểm, mà cũng có thể là mang cả hai đặc điểm trên.", "366", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 2, 5, 100, 0));
        db.ThemSach(new Sach(0, "HARRY POTTER VÀ PHÒNG CHỨA BÍ MẬT", 2, "J.K.Rowling", "2017", "600g", "14 x 20", "Harry khổ sở mong ngóng cho kì nghỉ hè kinh khủng với gia đình Dursley kết thúc. Nhưng một con gia tinh bé nhỏ tội nghiệp đã cảnh báo cho Harry biết về mối nguy hiểm chết người đang chờ cậu ở trường Hogwarts.\n" +
                "\n" +
                " Trở lại trường học, Harry nghe một tin đồn đang lan truyền về phòng chứa bí mật, nơi cất giữ những bí ẩn đáng sợ dành cho giới phù thủy có nguồn gốc Muggle. Có kẻ nào đó đang phù phép làm tê liệt mọi người, khiến họ gần như đã chết, và một lời cảnh báo kinh hoàng được tìm thấy trên bức tường. Mối nghi ngờ hàng đầu – và luôn luôn sai lầm – là Harry. Nhưng một việc còn đen tối hơn thế đã được hé mở.\n" +
                "\n" +
                "Harry Potter và phòng chứa bí mật, không như những bộ truyện nhiều tập khác, vẫn tuyệt hay như người anh em trước… Hogwarts là sáng tạo của một thiên tài.’- Times Literary Supplement.", "436", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 3, 1, 100, 0));
        db.ThemSach(new Sach(0, "HARRY POTTER VÀ TÊN TÙ NHÂN NGỤC AZKABAN", 2, "J.K.Rowling", "2017", "550g", "14 x 20", "Harry Potter may mắn sống sót đến tuổi 13, sau nhiều cuộc tấn công của Chúa tể hắc ám.\n" +
                "\n" +
                "Nhưng hy vọng có một học kỳ yên ổn với Quidditch của cậu đã tiêu tan thành mây khói khi một kẻ điên cuồng giết người hàng loạt vừa thoát khỏi nhà tù Azkaban, với sự lùng sục của những cai tù là giám ngục.\n" +
                "\n" +
                "Dường như trường Hogwarts là nơi an toàn nhất cho Harry lúc này. Nhưng có phải là sự trùng hợp khi cậu luôn cảm giác có ai đang quan sát mình từ bóng đêm, và những điềm báo của giáo sư Trelawney liệu có chính xác?", "560", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 4, 2, 100, 0));
        db.ThemSach(new Sach(0, "HARRY POTTER VÀ CHIẾC CỐC LỬA", 2, "J.K.Rowling", "2017", "920g", "14 x 20", "Khi giải Quidditch Thế giới bị cắt ngang bởi những kẻ ủng hộ Chúa tể Voldemort và sự trở lại của Dấu hiệu hắc ám khủng khiếp, Harry ý thức được rõ ràng rằng, Chúa tể Voldemort đang ngày càng mạnh hơn. Và để trở lại thế giới phép thuật, Chúa tể hắc ám cần phải đánh bại kẻ duy nhất sống sót từ lời nguyền chết chóc của hắn - Harry Potter. Vì lẽ đó, khi Harry bị buộc phải bước vào giải đấu Tam Pháp thuật uy tín nhưng nguy hiểm, cậu nhận ra rằng trên cả chiến thắng, cậu phải giữ được mạng sống của mình.", "922", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 5, 3, 100, 0));
        db.ThemSach(new Sach(0, "HARRY POTTER VÀ HỘI PHƯỢNG HOÀNG", 2, "J.K.Rowling", "2017", "1300g", "14 x 20", "Harry tức giận vì bị bỏ rơi ở nhà Dursley trong dịp hè, cậu ngờ rằng Chúa tể hắc ám Voldemort đang tập hợp lực lượng, và vì cậu có nguy cơ bị tấn công, những người Harry luôn coi là bạn đang cố che giấu tung tích cậu. Cuối cùng, sau khi được giải cứu, Harry khám phá ra rằng giáo sư Dumbledore đang tập hợp lại Hội Phượng Hoàng – một đoàn quân bí mật đã được thành lập từ những năm trước nhằm chống lại Chúa tể Voldemort. Tuy nhiên, Bộ Pháp thuật không ủng hộ Hội Phượng Hoàng, những lời bịa đặt nhanh chóng được đăng tải trên Nhật báo Tiên tri – một tờ báo của giới phù thủy, Harry lo ngại rằng rất có khả năng cậu sẽ phải gánh vác trách nhiệm chống lại cái ác một mình.", "1310", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 6, 4, 100, 0));
        db.ThemSach(new Sach(0, "HARRY POTTER VÀ HOÀNG TỬ LAI", 2, "J.K.Rowling", "2017", "600g", "13 x 20", "Đây là năm thứ 6 của Harry Potter tại trường Hogwarts. Trong lúc những thế lực hắc ám của Voldemort gieo rắc nỗi kinh hoàng và sợ hãi ở khắp nơi, mọi chuyện càng lúc càng trở nên rõ ràng hơn đối với Harry, rằng cậu sẽ sớm phải đối diện với định mệnh của mình. Nhưng liệu Harry đã sẵn sàng vượt qua những thử thách đang chờ đợi phía trước?\n" +
                "\n" +
                "Trong cuộc phiêu lưu tăm tối và nghẹt thở nhất của mình, J.K.Rowling bắt đầu tài tình tháo gỡ từng mắc lưới phức tạp mà cô đã mạng lên, cũng là lúc chúng ta khám phá ra sự thật về Harry, cụ Dumblebore, thầy Snape và, tất nhiên, Kẻ Chớ Gọi Tên Ra", "716", "Sách tiếng Việt", "NXB Trẻ", "Bìa Mềm", "HD", 1, 5, 100, 0));

        //Thêm hình ảnh sách
        db.ThemHinhAnhSach(new HinhAnhSach(1, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/a/mat_biec_bia_mem_in_lan_thu_44.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(2, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/m/image_180164_1_43_1_57_1_4_1_2_1_210_1_29_1_98_1_25_1_21_1_5_1_3_1_18_1_18_1_45_1_26_1_32_1_14_1_1233.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(3, "https://cdn0.fahasa.com/media/flashmagazine/images/page_images/lam_ban_voi_bau_troi___bia_cung/2020_03_28_10_45_11_1.JPG"));
        db.ThemHinhAnhSach(new HinhAnhSach(4, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/1/1/1111_1_7.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(5, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/m/i/minh_noi_gi_khi_noi_ve_hanh_phuc_1_2018_10_30_14_44_57.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(6, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/n/g/nguoi_lon_khong_khoc_1_2018_08_14_09_21_05.JPG"));
        db.ThemHinhAnhSach(new HinhAnhSach(7, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/k/h/khoi_troi_long_lay_tai_ban_2017_1_2019_02_20_16_09_49.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(8, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/k/h/khong_ai_qua_song_1_2019_02_20_16_09_34.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(9, "https://cdn0.fahasa.com/media/flashmagazine/images/page_images/inferno__film_tie_in__9780552172134/9/7/9780552172134-0.png"));
        db.ThemHinhAnhSach(new HinhAnhSach(10, "https://kbimages1-a.akamaihd.net/aad58714-db6b-45be-acbb-cc1b57bc8a84/1200/1200/False/angels-demons-1.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(11, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/9/7/9780141372563.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(12, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/p/e/percy_jackson_and_the_sea_of_monsters_book_2_1_2018_11_20_22_15_07.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(13, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/9/7/9780141346830.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(14, "https://nicholassparks.com/wp-content/uploads/2016/04/201708-two-by-two.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(15, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/t/h/the_last_song_1_2018_08_23_16_03_22.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(16, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/s/a/safe_haven_1_2019_02_16_09_13_31.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(17, "https://www.elle.vn/wp-content/uploads/2016/08/09/2012_-_The_Lucky_One_Movie_Poster.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(18, "https://prodimage.images-bn.com/pimages/9780062024329_p0_v1_s550x406.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(19, "https://images-na.ssl-images-amazon.com/images/I/81RqcfX%2Bf5L._SL1500_.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(20, "https://cdn0.fahasa.com/media/flashmagazine/images/page_images/harry_potter_va_hon_da_phu_thuy___tap_1_tai_ban_2017_/2019_09_19_16_47_48_1.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(21, "https://cdn0.fahasa.com/media/flashmagazine/images/page_images/harry_potter_va_phong_chua_bi_mat___tap_2_tai_ban_2017_/2019_09_19_17_07_39_1.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(22, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/a/harry_potter_va_ten_tu_nhan_nguc_azkaban___tap_3_tai_ban_2017_1_2018_07_05_11_00_26.JPG"));
        db.ThemHinhAnhSach(new HinhAnhSach(23, "https://cdn0.fahasa.com/media/flashmagazine/images/page_images/harry_potter_va_chiec_coc_lua___tap_4_tai_ban_2017/2019_09_20_15_51_34_1.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(24, "https://isach.info/images/story/cover/harry_potter_va_mat_lenh_phuong_hoang__j_k_rowling.jpg"));
        db.ThemHinhAnhSach(new HinhAnhSach(25, "https://cdn0.fahasa.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/h/a/harrypottervahoangtulaitap6.jpg"));

        //Thêm admin
        db.ThemTaiKhoan(new TaiKhoan("admin", "Đỗ Tấn Lộc", "1", "10/05/1998", "Nam", "103/14 Trần Văn Đang P9 Q3"));
    }
}
