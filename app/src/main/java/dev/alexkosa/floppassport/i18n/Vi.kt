package dev.alexkosa.floppassport.i18n

/**
 * Vietnamese.
 *
 * The key is the English sentence exactly as the screen produces it, so a change to the
 * English orphans the entry here rather than letting the two drift apart silently. Anything
 * missing renders English, which keeps a gap cosmetic instead of breaking a screen.
 *
 * Product and protocol names stay in Latin script on purpose - FLOP, Seeker, Seed Vault,
 * StrongBox, Technocore, did:key, SKR. They are what a person sees everywhere else on the
 * phone, and translating them would make this app the only place they are called something
 * different.
 *
 * Generated from the phrase catalogue and checked for lost product names, eaten leading
 * spaces and entries left in English; the wording was then read through.
 */
internal val VI_STRINGS: Map<String, String> = mapOf(
    "06  tell them" to "06  kể cho mọi người",
    "5 of 6" to "5 trên 6",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "Thêm vài chữ nữa là xong. Chỉ cần một câu thật.",
    "A few reminders about the last step, and then they stop." to
        "Vài lời nhắc về bước cuối, rồi sẽ thôi.",
    "A little too long. Trim it and the whole post fits, key included." to
        "Hơi dài. Rút ngắn lại là cả bài vừa đủ, kể cả khóa.",
    "A once-a-day reminder to leave today's signed record." to
        "Mỗi ngày một lời nhắc để lưu lại bản ghi đã ký của hôm nay.",
    "A public note at an address derived from your key, so anyone can find and verify you later. This one goes to technocore.chat, which is someone else's public service: when it is busy it refuses, and pressing again is the answer. Two or three attempts is normal and means nothing is wrong with your phone." to
        "Một ghi chú công khai ở địa chỉ tính ra từ khóa của bạn, để sau này ai cũng tìm được và kiểm chứng được bạn. Bước này đi tới technocore.chat, dịch vụ công cộng của người khác: khi bận nó sẽ từ chối, và cách xử lý là bấm lại. Hai ba lần thử là bình thường và có nghĩa là máy của bạn không sao cả.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later. This is also the switch that warns you before your identity note is deleted." to
        "Bạn phải tự ký một bản ghi mỗi ngày và không thể bổ sung cho ngày đã bỏ lỡ. Đây cũng là công tắc cảnh báo bạn trước khi ghi chú danh tính bị xóa.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Tiền ủng hộ không thay đổi gì về Passport của bạn hay bất kỳ airdrop nào.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Tiền ủng hộ không thay đổi gì về Passport của bạn hay bất kỳ airdrop nào. Đây là lời cảm ơn, không phải phí.",
    "About" to "Giới thiệu",
    "Accepted, but we could not read it back yet" to
        "Đã được chấp nhận, nhưng chưa thể đọc lại",
    "Activity" to "Hoạt động",
    "All six done" to "Xong cả sáu bước",
    "Already checked in, found in the room" to "Đã điểm danh, đã tìm thấy trong phòng",
    "Already published, read back just now" to "Đã công bố, vừa đọc lại",
    "Android is blocking notifications for this app. Turn them on in the system settings." to
        "Android đang chặn thông báo của ứng dụng này. Hãy bật thông báo trong phần cài đặt hệ thống.",
    "Anyone can check it at the address in step 03. This app promises nothing about any allocation, and never will." to
        "Bất kỳ ai cũng có thể kiểm tra tại địa chỉ ở bước 03. Ứng dụng này không hứa hẹn bất kỳ phân bổ nào và sẽ không bao giờ làm vậy.",
    "Anyone holding it can sign as you" to
        "Bất kỳ ai giữ nó đều có thể ký dưới danh nghĩa của bạn",
    "Anyone holding seed_hex can sign as this identity on Technocore." to
        "Bất kỳ ai giữ seed_hex đều có thể ký bằng danh tính này trên Technocore.",
    "Anyone who looks it up sees a key and nothing else." to
        "Ai tra nó cũng chỉ thấy một cái khóa, không có gì khác.",
    "Anyone with this can be you" to "Bất kỳ ai có thứ này đều có thể mạo danh bạn",
    "Apply" to "Áp dụng",
    "Cancel" to "Hủy",
    "Check in" to "Điểm danh",
    "Check your connection and try again." to "Kiểm tra kết nối rồi thử lại.",
    "Could not open the security prompt on this screen." to
        "Không thể mở yêu cầu bảo mật trên màn hình này.",
    "Could not reach technocore.chat" to "Không thể kết nối tới technocore.chat",
    "Could not reach technocore.chat. This says nothing about your records, only about the connection." to
        "Không thể kết nối tới technocore.chat. Điều này không phản ánh trạng thái bản ghi của bạn, chỉ phản ánh kết nối.",
    "Could not reach the server." to "Không thể kết nối với máy chủ.",
    "Could not read the key back from secure storage" to
        "Không thể đọc lại khóa từ bộ nhớ bảo mật",
    "Create" to "Tạo",
    "Create your Passport" to "Tạo Passport của bạn",
    "Create your Passport first. There is nothing to show until something has been signed." to
        "Trước tiên, hãy tạo Passport. Chưa có gì để hiển thị cho đến khi một nội dung được ký.",
    "Daily activity" to "Hoạt động hằng ngày",
    "Daily reminder" to "Lời nhắc hằng ngày",
    "Delete it?" to "Xóa chứ?",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Việc xóa chỉ gỡ Passport khỏi điện thoại này. Mọi nội dung đã công bố có thể vẫn công khai, và cùng một ví sẽ tạo lại cùng một danh tính - vì vậy đây không phải là cách hoàn tác bất kỳ điều gì.",
    "Did you post it?" to "Bạn đã đăng chưa?",
    "Every language listed here has a full translation." to
        "Mọi ngôn ngữ được liệt kê ở đây đều có bản dịch đầy đủ.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport tạo danh tính Technocore từ ví Solana của bạn và lưu các biên nhận.",
    "FLOP Passport for Seeker" to "FLOP Passport cho Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport cho Seeker - bản sao lưu riêng tư",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport cho Seeker, bởi @AlexKosa1",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP yêu cầu các tác nhân làm hai việc: tạo một khóa duy nhất và làm điều gì đó hữu ích để lan truyền thông tin về Technocore. Năm bước trên đã hoàn thành việc đầu tiên. Không ai có thể làm việc thứ hai thay bạn, nên ứng dụng sẽ viết bài đăng và bạn quyết định có gửi hay không.",
    "Identity derived from your wallet signature" to "Danh tính được tạo từ chữ ký ví của bạn",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Nếu ghi chú bị xóa, Passport của bạn vẫn không mất: cùng một ví vẫn tạo ra cùng một danh tính, và việc ký một bản ghi sẽ đăng lại ghi chú tại cùng một địa chỉ.",
    "In one line: what you did, or why you set this up" to
        "Một dòng thôi: bạn đã làm gì, hoặc vì sao bạn lập cái này",
    "It never asks for your wallet recovery phrase." to
        "Ứng dụng không bao giờ yêu cầu cụm từ khôi phục ví của bạn.",
    "It promises nothing about any airdrop, and never will." to
        "Ứng dụng không hứa hẹn gì về bất kỳ airdrop nào và sẽ không bao giờ làm vậy.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Giữ tệp này ngoại tuyến. Không bao giờ gửi cho bất kỳ ai, kể cả tác giả ứng dụng.",
    "Language" to "Ngôn ngữ",
    "Last reminder about this one." to "Đây là lời nhắc cuối về việc này.",
    "Make your first signed check-in" to "Tạo bản ghi có chữ ký đầu tiên",
    "Next: create your Passport from your wallet." to "Tiếp theo: tạo Passport từ ví của bạn.",
    "Next: make your first signed check-in." to "Tiếp theo: tạo bản ghi có chữ ký đầu tiên.",
    "Next: publish your identity so anyone can verify you." to
        "Tiếp theo: công bố danh tính để bất kỳ ai cũng có thể xác minh bạn.",
    "Next: seal the key in this phone's secure storage." to
        "Tiếp theo: niêm phong khóa trong bộ nhớ bảo mật của điện thoại này.",
    "No account, no server of ours, no analytics." to
        "Không tài khoản, không máy chủ riêng, không phân tích dữ liệu.",
    "No wallet on this phone opened the payment link." to
        "Không có ví nào trên điện thoại này mở liên kết thanh toán.",
    "No. Nothing was published." to "Không. Không có gì được công bố.",
    "Not checked yet." to "Chưa kiểm tra.",
    "Not done. Your Passport is not attached to any public name yet, and this is the one step nobody can do for you." to
        "Chưa xong. Passport của bạn vẫn chưa gắn với tên công khai nào, và đây là bước không ai làm thay bạn được.",
    "Nothing asked yet" to "Chưa có câu hỏi nào",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Không tìm thấy gì. Nếu bạn đã ký nội dung nhưng không thấy ở đây, phòng đã lược bỏ phần chứa nội dung đó - đây là điều bình thường và chính là lý do màn hình này tồn tại.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Chưa có gì bảo chứng cho nội dung này. Hãy đăng lại để ký cho nó.",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "Không có gì hỏng và không mất gì cả. Passport của bạn vẫn chạy. Khi nào bạn muốn nửa công khai của nó, bước 06 vẫn ở chỗ bạn để lại.",
    "Nothing signed today yet." to "Hôm nay chưa có nội dung nào được ký.",
    "One step left" to "Còn một bước",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Chỉ những ngôn ngữ có bản dịch thực sự mới được liệt kê. Một bộ chọn cung cấp các ngôn ngữ nhưng đều hiển thị bằng tiếng Anh sẽ báo rằng ngôn ngữ của bạn được hỗ trợ, rồi cho thấy điều ngược lại ở màn hình tiếp theo.",
    "Opening a connection" to "Đang mở kết nối",
    "Opening your Solana wallet" to "Đang mở ví Solana của bạn",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "Hãy đăng dòng của bạn, rồi quay lại dán liên kết. Chính điều đó gắn tên bạn với khóa của bạn, và đó là nửa phần FLOP đã yêu cầu các tác nhân làm.",
    "Protect" to "Bảo vệ",
    "Protect it" to "Bảo vệ khóa",
    "Publish" to "Công bố",
    "Publish your identity" to "Công bố danh tính của bạn",
    "Published and read back from the server" to "Đã công bố và đọc lại từ máy chủ",
    "Published, read back, and vouched for by your key" to
        "Đã công bố, đọc lại và được khóa của bạn chứng thực",
    "Publishing your identity note to technocore.chat" to
        "Đang công bố ghi chú danh tính lên technocore.chat",
    "Publishing your note" to "Đang công bố ghi chú của bạn",
    "Questions, answered in full" to "Câu hỏi, được giải đáp đầy đủ",
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Vừa được đọc từ technocore.chat, không phải từ điện thoại này. Các phòng được lược bớt khi lớn dần, nên đây là nội dung bất kỳ ai cũng sẽ tìm thấy hôm nay.",
    "Reading your note" to "Đang đọc ghi chú của bạn",
    "Reading your records" to "Đang đọc các bản ghi của bạn",
    "Ready" to "Sẵn sàng",
    "Remind me once a day" to "Nhắc tôi mỗi ngày một lần",
    "Renewed today. technocore.chat keeps it for seven days after the last write, and this app rewrites it every time you open it." to
        "Đã gia hạn hôm nay. technocore.chat giữ ghi chú trong bảy ngày kể từ lần ghi gần nhất, và ứng dụng này ghi lại ghi chú mỗi khi bạn mở ứng dụng.",
    "Sealed by Android Keystore" to "Được niêm phong bằng Android Keystore",
    "Sealed by StrongBox, this phone's separate security chip" to
        "Được niêm phong bằng StrongBox, chip bảo mật riêng của điện thoại này",
    "Sealed by this phone's trusted execution environment" to
        "Được niêm phong bằng môi trường thực thi tin cậy của điện thoại này",
    "Sealing the key in this device's secure storage" to
        "Đang niêm phong khóa trong bộ nhớ bảo mật của thiết bị",
    "Sending your signed record" to "Đang gửi bản ghi có chữ ký của bạn",
    "Sent, but not confirmed in the room yet" to "Đã gửi nhưng chưa được xác nhận trong phòng",
    "Settings" to "Cài đặt",
    "Show your private key" to "Hiển thị khóa riêng của bạn",
    "Signed, accepted and found again in the room" to
        "Đã ký, được chấp nhận và tìm thấy lại trong phòng",
    "Signing your first check-in and sending it" to "Đang ký và gửi bản ghi đầu tiên",
    "Somebody changed this note after your key signed for it. Publish again." to
        "Ai đó đã sửa ghi chú này sau khi khóa của bạn bảo chứng cho nó. Hãy đăng lại.",
    "Still one step short" to "Vẫn còn thiếu một bước",
    "Talking to the service" to "Đang liên lạc với dịch vụ",
    "Thanks for building this" to "Cảm ơn vì đã xây dựng ứng dụng này",
    "That does not look like a link to a post. It should look like https://x.com/you/status/123." to
        "Đây có vẻ không phải là liên kết đến một bài đăng. Liên kết phải có dạng https://x.com/you/status/123.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Khóa được niêm phong trong bộ nhớ bảo mật của điện thoại này, sau đó được đọc lại và đối chiếu với danh tính của bạn.",
    "The manual" to "Hướng dẫn",
    "The server is busy. Trying again." to "Máy chủ đang bận. Đang thử lại.",
    "The stored key does not match your identity" to
        "Khóa đã lưu không khớp với danh tính của bạn",
    "The wallet did not complete the signature" to "Ví chưa hoàn tất việc ký",
    "There are no points here and no score. FLOP asked agents to do something useful, so what counts is a record a person can still open. A number invented by this app would be a different game." to
        "Ở đây không có điểm thưởng hay điểm số. FLOP yêu cầu các tác nhân làm điều hữu ích, nên điều có giá trị là một bản ghi mà người khác vẫn có thể mở. Một con số do ứng dụng này tự đặt ra sẽ là một trò chơi khác.",
    "These 32 bytes are your FLOP Passport itself. Whoever holds them can sign as you on Technocore. Keep them offline and never send them to anyone, including us." to
        "32 byte này chính là FLOP Passport của bạn. Bất kỳ ai giữ chúng đều có thể ký dưới danh nghĩa của bạn trên Technocore. Hãy giữ chúng ngoại tuyến và không bao giờ gửi cho bất kỳ ai, kể cả chúng tôi.",
    "This app is free and open source, and nobody paid for it. If it saved you an afternoon, a tip is welcome." to
        "Ứng dụng này miễn phí, mã nguồn mở và không ai trả tiền để làm nó. Nếu nó giúp bạn tiết kiệm một buổi chiều, bạn có thể gửi tiền ủng hộ.",
    "This app is free and open source. If it was useful, you can send a tip to {name}. Your wallet opens and you choose the amount there." to
        "Ứng dụng này miễn phí và mã nguồn mở. Nếu nó hữu ích, bạn có thể gửi tiền ủng hộ tới {name}. Ví của bạn sẽ mở ra và bạn chọn số tiền ở đó.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Ứng dụng này ghi lại ghi chú mỗi khi bạn mở ứng dụng và mỗi khi bạn ký một bản ghi, nên thời hạn bảy ngày sẽ bắt đầu lại. Hãy mở ứng dụng ít nhất một lần mỗi tuần để không bao giờ mất gì.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Đây KHÔNG phải khóa ví Solana của bạn. Khóa của ví không bao giờ rời Seed Vault và ứng dụng này chưa từng thấy nó. Thứ bạn đang xem là một khóa riêng biệt, chỉ dùng để ký trên Technocore.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "Chính câu này khiến bài đăng là của bạn. Mọi thứ bên dưới là bằng chứng.",
    "Three days left before it is deleted." to "Còn ba ngày trước khi ghi chú bị xóa.",
    "Today cannot be added later" to "Hôm nay không thể thêm vào sau",
    "Told only when your identity note is days away from being deleted." to
        "Chỉ thông báo khi ghi chú danh tính của bạn sắp bị xóa trong vài ngày tới.",
    "Tomorrow is the last day." to "Ngày mai là ngày cuối cùng.",
    "Two days left before it is deleted." to "Còn hai ngày trước khi ghi chú bị xóa.",
    "Unfinished setup" to "Thiết lập chưa xong",
    "Use the phone's language" to "Sử dụng ngôn ngữ của điện thoại",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Chờ một lát rồi nhấn lại để kiểm tra. Không nên xem đây là lỗi.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Chờ một lát rồi nhấn lại để kiểm tra. Gửi dưới dạng tin nhắn mới sẽ đăng công khai hai lần.",
    "What is still provable" to "Những gì vẫn có thể chứng minh",
    "What recovery without a seed phrase costs" to
        "Khôi phục không cần cụm từ khôi phục có cái giá của nó",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "Cần làm gì và bao lâu một lần, vì sao danh tính hết hạn, vì sao cách này hoạt động trên Seeker và có điều gì cần lưu ý. Mở trong trình duyệt của bạn.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "Hãy viết một dòng mà chỉ bạn mới viết ra. Những bài chỉ khác nhau đúng một cái khóa sẽ bị coi là cày kéo, và người chịu thiệt là những ai thật sự đã làm việc.",
    "Yes. Something is already visible to others." to
        "Có. Một số nội dung đã hiển thị với người khác.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Bạn không cần tệp này để khôi phục. Chính ví Solana đã",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Bạn không cần thứ này để khôi phục. Cùng một ví Solana sẽ dựng lại cùng một Passport trên bất kỳ điện thoại nào. Bản sao này dùng để sử dụng khóa ở nơi khác theo quyết định của bạn.",
    "You finished the five. The last one takes a minute." to
        "Bạn đã xong năm bước. Bước cuối chỉ mất một phút.",
    "You have already checked in" to "Bạn đã điểm danh rồi",
    "You have already left a record today." to "Hôm nay bạn đã để lại một bản ghi.",
    "You're all set" to "Đã hoàn tất",
    "Your Passport has no name on it" to "Passport của bạn chưa có tên",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passport của bạn được dẫn xuất từ một chữ ký do ví tạo trong Seed Vault, kho khóa phần cứng của Seeker. Khóa ví không bao giờ rời khỏi phần cứng đó. Khóa Passport được tính từ chữ ký này trong ứng dụng rồi được bộ nhớ bảo mật của Android niêm phong - được niêm phong, không phải được ký, trong phần cứng, vì Android Keystore không thể lưu loại khóa này.",
    "Your Passport is live" to "Passport của bạn đang hoạt động",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport của bạn đang hoạt động và bản ghi có chữ ký đầu tiên đã có trên Technocore. Bất kỳ ai cũng có thể xác minh và nó vẫn thuộc về bạn.",
    "Your Passport is live. One step left." to "Passport của bạn đang hoạt động. Còn một bước.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passport của bạn được dựng lại từ một chữ ký ví duy nhất, nên không có cụm từ khôi phục nào để mất. Điều đó cũng đúng theo chiều ngược lại: bất kỳ ứng dụng nào thuyết phục được ví của bạn ký đúng câu đó đều có thể dựng lại Passport này. Hãy đọc kỹ những gì một ví yêu cầu bạn ký, ở đây và ở mọi nơi.",
    "Your identity note expires soon" to "Ghi chú danh tính của bạn sắp hết hạn",
    "Your identity note has been deleted" to "Ghi chú danh tính của bạn đã bị xóa",
    "Your key is never sent anywhere. Only you can export it." to
        "Khóa của bạn không bao giờ được gửi đi đâu. Chỉ bạn mới có thể xuất khóa.",
    "Your key signed a line carrying this note's exact hash." to
        "Khóa của bạn đã ký một dòng mang đúng mã băm của ghi chú này.",
    "Your note has to be kept alive" to "Ghi chú của bạn cần được duy trì",
    "Your post is in your identity note, at your key's own address." to
        "Bài đăng của bạn đã nằm trong ghi chú danh tính, ngay tại địa chỉ của chính khóa bạn.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Ví của bạn ký một tuyên bố. Đây không phải giao dịch và không chuyển tiền. Cùng ví đó sẽ dựng lại cùng một Passport trên bất kỳ thiết bị nào.",
    "active days" to "ngày hoạt động",
    "activity" to "hoạt động",
    "address" to "địa chỉ",
    "algorithm: Ed25519, did:key, 32-byte seed" to "thuật toán: Ed25519, did:key, seed 32 byte",
    "attach it" to "gắn vào",
    "built by a community builder" to "do một nhà phát triển cộng đồng xây dựng",
    "cancel" to "hủy",
    "change" to "thay đổi",
    "changed" to "đã thay đổi",
    "check again" to "kiểm lại",
    "checked" to "đã kiểm tra",
    "close" to "đóng",
    "connection" to "kết nối",
    "content" to "nội dung",
    "continue" to "tiếp tục",
    "copy" to "sao chép",
    "copy key" to "sao chép khóa",
    "create passport" to "tạo passport",
    "created this Passport rebuilds it on any device." to
        "tạo Passport này sẽ dựng lại nó trên bất kỳ thiết bị nào.",
    "danger zone" to "vùng nguy hiểm",
    "day streak" to "chuỗi ngày liên tiếp",
    "delete passport from this phone" to "xóa passport khỏi điện thoại này",
    "detail" to "chi tiết",
    "did anything go public?" to "có nội dung nào đã công khai không?",
    "done" to "xong",
    "failed" to "thất bại",
    "fetched again and matched exactly" to "đã tải lại và khớp hoàn toàn",
    "fetched from the server on opening" to "được tải từ máy chủ khi mở",
    "fingerprint" to "dấu vân",
    "flop-passport vault self-test" to "tự kiểm tra két flop-passport",
    "identity" to "danh tính",
    "identity note" to "ghi chú danh tính",
    "language {code}" to "ngôn ngữ {code}",
    "last connection" to "kết nối gần nhất",
    "linked" to "đã liên kết",
    "live records" to "bản ghi đang công khai",
    "matched on our nonce, not just our key" to
        "khớp với nonce của chúng tôi, không chỉ với khóa",
    "no thanks, continue" to "không, cảm ơn, tiếp tục",
    "no, nothing was made public" to "không, chưa có gì được công khai",
    "nonce" to "nonce",
    "not found" to "không tìm thấy",
    "not yet" to "chưa",
    "not yet - the note alone is a claim, not a proof" to
        "chưa - riêng ghi chú chỉ là một tuyên bố, không phải bằng chứng",
    "off" to "tắt",
    "on" to "bật",
    "open" to "mở",
    "our exact bytes, no wallet prefix" to "đúng các byte của chúng tôi, không có tiền tố ví",
    "passport for seeker" to "passport cho seeker",
    "pin it to your identity" to "ghim vào danh tính của bạn",
    "private key, 32 bytes, hex" to "khóa riêng, 32 byte, hex",
    "protect passport" to "bảo vệ passport",
    "publish identity" to "công bố danh tính",
    "published" to "đã công bố",
    "publishing" to "đang công bố",
    "re-check with the server" to "kiểm tra lại với máy chủ",
    "re-checked when the app opened" to "đã kiểm tra lại khi mở ứng dụng",
    "records the server still holds" to "các bản ghi máy chủ vẫn còn lưu",
    "recovery" to "khôi phục",
    "room" to "phòng",
    "save to a file" to "lưu vào tệp",
    "say it another way" to "nói cách khác",
    "self test" to "tự kiểm tra",
    "send a tip" to "gửi tiền ủng hộ",
    "send a tip in {token}" to "gửi tiền ủng hộ bằng {token}",
    "send a tip to {name}" to "gửi tiền ủng hộ tới {name}",
    "sequence" to "số thứ tự",
    "settings" to "cài đặt",
    "sign and check in" to "ký và điểm danh",
    "sign today's record" to "ký bản ghi hôm nay",
    "signed" to "đã ký",
    "signed and verified against your DID" to "đã ký và xác minh theo DID của bạn",
    "step {n} {title} complete" to "bước {n} {title} đã xong",
    "step {n} {title} did not finish" to "bước {n} {title} chưa xong",
    "storage" to "lưu trữ",
    "support the builder" to "ủng hộ nhà phát triển",
    "technocore.chat answered" to "technocore.chat đã phản hồi",
    "technocore.chat deletes anything nobody has written to for seven days. That includes the identity note at the address you save and share." to
        "technocore.chat xóa mọi nội dung không được ai ghi thêm trong bảy ngày. Điều này bao gồm ghi chú danh tính tại địa chỉ bạn lưu và chia sẻ.",
    "technocore.chat refused the note" to "technocore.chat đã từ chối ghi chú",
    "technocore.chat refused the signed write" to
        "technocore.chat đã từ chối bản ghi có chữ ký",
    "text" to "văn bản",
    "the note changed between reads" to "ghi chú đã thay đổi giữa hai lần đọc",
    "the post" to "bài đăng",
    "the same wallet rebuilds this identity anywhere" to
        "cùng ví đó dựng lại danh tính này ở bất kỳ đâu",
    "try again" to "thử lại",
    "unconfirmed" to "chưa xác nhận",
    "unsigned" to "chưa ký",
    "verified" to "đã xác minh",
    "verify it yourself" to "tự xác minh",
    "version" to "phiên bản",
    "vouched for" to "được chứng thực",
    "wallet" to "ví",
    "wallet linked" to "đã liên kết ví",
    "what this app never does" to "những điều ứng dụng này không bao giờ làm",
    "what to do" to "cần làm gì",
    "when" to "thời điểm",
    "working" to "đang xử lý",
    "yes, a signed did-note line carries its hash" to
        "có, một dòng did-note có chữ ký chứa mã băm của nó",
    "yes, delete" to "có, xóa",
    "yes, something is already public" to "có, một số nội dung đã công khai",
    "your identity" to "danh tính của bạn",
    "your private key" to "khóa riêng của bạn",
    "{token} is preselected and you can switch it." to
        "{token} đã được chọn sẵn và bạn có thể đổi.",
    "Try again. Nothing was sent anywhere." to
        "Hãy thử lại. Không có gì được gửi đi đâu cả.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "Hãy thử lại. technocore.chat là một dịch vụ công cộng và nó từ chối ghi khi đang bận, chuyện đó không liên quan gì tới ứng dụng này, tới máy của bạn hay tới khóa của bạn. Hai ba lần thử là bình thường. Không có gì được công bố.",
    "Try again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "Hãy thử lại. technocore.chat là một dịch vụ công cộng và nó từ chối ghi khi đang bận, chuyện đó không liên quan gì tới ứng dụng này, tới máy của bạn hay tới khóa của bạn. Hai ba lần thử là bình thường. Không có gì được gửi đi.",
    "Could not reach technocore.chat. Check your connection and try again; nothing was lost." to
        "Không kết nối được tới technocore.chat. Hãy kiểm tra kết nối rồi thử lại; không mất gì cả.",
    "The service took your record but has not shown it back yet. Press re-check in a moment; nothing needs signing again." to
        "Dịch vụ đã nhận bản ghi của bạn nhưng chưa hiển thị lại. Lát nữa hãy bấm kiểm tra lại; không cần ký lại gì cả.",
    "technocore.chat refused the record. It refuses writes when it is busy - try again in a moment." to
        "technocore.chat đã từ chối bản ghi. Nó từ chối ghi khi đang bận - lát nữa hãy thử lại.",
    "Not finished yet. Your Passport is not live until all five are green, and there is nothing complete for anyone to verify. Keep going." to
        "Vẫn chưa xong. Passport của bạn chưa hoạt động cho tới khi cả năm bước đều xanh, và chưa có gì hoàn chỉnh để ai đó kiểm chứng. Cứ tiếp tục.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. That is the service being busy, not a problem with your key." to
        "Một tin nhắn do Passport của bạn ký, gửi vào một căn phòng yên tĩnh rồi đọc lại để chứng minh nó đã tới nơi. Vẫn là dịch vụ ở bước 03, và vẫn quy tắc ấy: nếu bị từ chối thì bấm lại. Đó là dịch vụ đang bận, không phải khóa của bạn có vấn đề.",
    "Deleted after seven days with nothing written to it. Publish it now and it goes back to the same address." to
        "Bị xóa sau bảy ngày không có gì được ghi vào. Hãy công bố lại ngay, nó sẽ trở về đúng địa chỉ cũ.",
    "Identity note at risk" to
        "Ghi chú danh tính đang gặp rủi ro",
    "In Settings, delete the Passport from this phone, then create it again from your wallet." to
        "Vào Cài đặt, xóa Passport khỏi máy này, rồi tạo lại từ ví của bạn.",
    "It is deleted after seven days with nothing written to it. Opening this app writes it." to
        "Nó bị xóa sau bảy ngày không có gì được ghi vào. Chỉ cần mở ứng dụng này là đã ghi vào nó.",
    "Maybe. The service accepted it, and this app could not read it back to be sure." to
        "Có thể. Dịch vụ đã nhận, nhưng ứng dụng này chưa đọc lại được để chắc chắn.",
    "That was the last of the five. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Đó là bước cuối trong năm bước. Passport của bạn đã hoạt động. Còn lại một việc, và đó đúng là điều FLOP đã đề nghị: kể cho mọi người biết bạn đã làm gì. Bài đăng thì ứng dụng viết sẵn cho bạn, ở cuối màn hình này.",
    "This app is free and there is nothing in it to buy. If it has been useful, a thank you can go to kosa.skr." to
        "Ứng dụng này miễn phí và bên trong không có gì để mua. Nếu nó có ích, một lời cảm ơn có thể gửi tới kosa.skr.",
    "checking" to
        "đang kiểm tra",
    "open notification settings" to
        "mở cài đặt thông báo",
    "send a tip to kosa.skr" to
        "gửi tiền ủng hộ tới kosa.skr",
    "show my private key" to
        "hiện khóa riêng của tôi",
    "step {n} {title} not confirmed yet" to
        "bước {n} {title} chưa được xác nhận",
    "technocore.chat deletes anything with no write for seven days. Opening this app rewrites your note, and so does signing a record. Either one starts the seven days again." to
        "technocore.chat xóa mọi thứ mà bảy ngày không ai ghi vào. Mở ứng dụng này là ghi lại ghi chú của bạn, ký một bản ghi cũng vậy. Chỉ cần một trong hai là bảy ngày được tính lại từ đầu.",
    "This phone has no screen lock set up. Add a PIN or a fingerprint first." to
        "Máy này chưa đặt khóa màn hình. Hãy đặt mã PIN hoặc vân tay trước đã.",
    "The server accepted the write but the message is not in the room yet. Do not resend: read the room again first." to
        "Máy chủ đã nhận lệnh ghi nhưng tin nhắn chưa có trong phòng. Đừng gửi lại: hãy đọc lại phòng trước đã.",
    "The stored text differs from the text we signed" to
        "Văn bản đã lưu khác với văn bản chúng tôi đã ký",
    "The stored record did not verify against this key" to
        "Bản ghi đã lưu không kiểm chứng được bằng khóa này",
    "You made a key only your wallet can rebuild, sealed it in this phone, published it where a stranger can find it, signed a record and proved it landed, and put your post beside your key. There is nothing left to set up." to
        "Bạn đã tạo một khóa mà chỉ ví của bạn dựng lại được, niêm phong nó trong chiếc máy này, công bố ở nơi người lạ cũng tìm thấy, ký một bản ghi và chứng minh nó đã tới nơi, rồi đặt bài đăng của bạn bên cạnh khóa. Không còn gì phải thiết lập nữa.",
    "open Activity" to
        "mở Hoạt động",
    "{n} more characters and the button below wakes up." to
        "Thêm {n} ký tự nữa là nút bên dưới sẽ bật lên.",
    "A signed record is dated evidence that you were here. A day without one cannot be added later, and signing also keeps your identity note alive. Nothing here promises anything about any allocation." to
        "Một bản ghi đã ký là bằng chứng có ngày tháng rằng bạn đã ở đây. Một ngày không có bản ghi không thể thêm vào sau, và việc ký cũng giữ cho ghi chú danh tính của bạn còn sống. Không có gì ở đây hứa hẹn bất kỳ phân bổ nào.",
    "Could not check technocore.chat for your published steps. This says nothing about them, only about the connection. Re-check when you are back online." to
        "Không thể hỏi technocore.chat về các bước bạn đã công bố. Điều này không nói gì về chúng, chỉ về kết nối. Kiểm tra lại khi bạn có mạng.",
    "Could not reach technocore.chat. Check your connection and press publish again. Your link is saved on this phone either way." to
        "Không kết nối được với technocore.chat. Kiểm tra kết nối và nhấn công bố lại. Liên kết của bạn vẫn được lưu trên điện thoại này.",
    "Could not read the key from secure storage. Restart the phone and try again." to
        "Không đọc được khóa từ bộ lưu trữ an toàn. Khởi động lại điện thoại và thử lại.",
    "FLOP Passport is an independent community project. It is not made, endorsed or reviewed by FLOP Labs or by Solana Mobile." to
        "FLOP Passport là một dự án cộng đồng độc lập. Nó không do FLOP Labs hay Solana Mobile tạo ra, xác nhận hay xem xét.",
    "Finish the steps on the Passport tab first. Daily records start once your Passport is live." to
        "Hãy hoàn thành các bước ở thẻ Passport trước. Bản ghi hằng ngày bắt đầu khi Passport của bạn hoạt động.",
    "From now on: open the app at least once a week, so your identity note is not deleted. On the days you do something, open Activity and sign that day's record - a day cannot be added later." to
        "Từ giờ: mở ứng dụng ít nhất một lần mỗi tuần để ghi chú danh tính không bị xóa. Vào những ngày bạn làm được gì đó, mở Hoạt động và ký bản ghi của ngày đó; một ngày không thể thêm vào sau.",
    "If you did something today, sign a record for it now." to
        "Nếu hôm nay bạn đã làm được gì, hãy ký một bản ghi cho việc đó ngay.",
    "Link to your post on X" to
        "Liên kết đến bài đăng của bạn trên X",
    "Nothing was saved. Open your private key again and save it from there." to
        "Chưa lưu gì cả. Mở khóa riêng của bạn lại và lưu từ đó.",
    "Paste the link here and your name goes beside your key, in your identity note. This is the part people mean to do later and then do not." to
        "Dán liên kết vào đây và tên bạn sẽ đứng cạnh khóa của bạn, trong ghi chú danh tính. Đây là phần mọi người định làm sau rồi không làm.",
    "Paste the link to your post on X. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key. The app does not open the link or check the post; anyone reading your note can." to
        "Dán liên kết đến bài đăng của bạn trên X. Nó sẽ vào ghi chú danh tính, để ghi chú trỏ đến bài đăng và bài đăng mang khóa. Khi đó bất kỳ ai cũng có thể đối chiếu hai đầu với một khóa. Ứng dụng không mở liên kết hay kiểm tra bài đăng; ai đọc ghi chú của bạn cũng có thể làm việc đó.",
    "Read from technocore.chat, not from this phone. Rooms are trimmed as they grow, so this shows what anyone would find today." to
        "Đọc từ technocore.chat, không phải từ điện thoại này. Các phòng bị cắt gọn khi lớn dần, nên đây là những gì bất kỳ ai cũng sẽ thấy hôm nay.",
    "Seeker and Solana Mobile are trademarks of Solana Mobile, used only to say what this app is built for. FLOP and Technocore are names of the project whose public service this app writes to." to
        "Seeker và Solana Mobile là nhãn hiệu của Solana Mobile, chỉ dùng để nói ứng dụng này được xây cho thiết bị nào. FLOP và Technocore là tên của dự án mà ứng dụng này ghi vào dịch vụ công khai của họ.",
    "Seven days without opening the app. Open it and press publish; the note goes back to the same address." to
        "Bảy ngày không mở ứng dụng. Mở nó và nhấn công bố; ghi chú sẽ trở lại đúng địa chỉ cũ.",
    "The file could not be written. Try another location." to
        "Không ghi được tập tin. Hãy thử một vị trí khác.",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key, and it is where people stop." to
        "Năm bước đã xây nên danh tính của bạn. Ngoài chiếc điện thoại này chưa ai biết nó là của bạn. Bước 06 bên dưới: viết một dòng, đăng lên, rồi quay lại dán liên kết. Phần cuối đó là điều đặt tên bạn cạnh khóa của bạn, và cũng là nơi mọi người dừng lại.",
    "The key could not be sealed in this phone's secure storage" to
        "Không niêm phong được khóa trong bộ lưu trữ an toàn của điện thoại này",
    "The link you paste goes into your identity note, at an address derived from your own key. The note stays as long as you keep opening the app; seven days without a write and it is deleted." to
        "Liên kết bạn dán sẽ vào ghi chú danh tính, tại một địa chỉ suy ra từ chính khóa của bạn. Ghi chú còn đó chừng nào bạn còn mở ứng dụng; bảy ngày không ghi là nó bị xóa.",
    "The note was accepted, but it could not be read back yet." to
        "Ghi chú đã được chấp nhận nhưng chưa đọc lại được.",
    "The record was sent but no answer came back in time. Do not resend: read the room again first." to
        "Bản ghi đã gửi nhưng không nhận được trả lời kịp. Đừng gửi lại: hãy đọc lại phòng trước.",
    "Three things, in this order: write your line, post it on X, then come back and paste the link. The last one is what puts your name beside your key, and it is the one people forget." to
        "Ba việc, theo thứ tự này: viết dòng của bạn, đăng lên X, rồi quay lại dán liên kết. Việc cuối là điều đặt tên bạn cạnh khóa của bạn, và cũng là việc mọi người hay quên.",
    "Today is the last day. It is deleted within 24 hours unless you open the app." to
        "Hôm nay là ngày cuối. Nó sẽ bị xóa trong 24 giờ nữa trừ khi bạn mở ứng dụng.",
    "Try again. If it keeps failing, restart the phone and try once more. Nothing was sent anywhere." to
        "Thử lại. Nếu vẫn thất bại, khởi động lại điện thoại và thử thêm lần nữa. Không có gì được gửi đi đâu cả.",
    "Your Passport is live, it is yours, and your post link is on it." to
        "Passport của bạn đang hoạt động, là của bạn, và liên kết bài đăng đã nằm trên đó.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and publishing again puts the note back at the same address." to
        "Bản thân Passport không mất: cùng chiếc ví vẫn cho ra cùng danh tính, và công bố lại sẽ đưa ghi chú trở về đúng địa chỉ cũ.",
    "checking with the server" to
        "đang kiểm tra với máy chủ",
    "independent project" to
        "dự án độc lập",
    "not in your note yet" to
        "chưa có trong ghi chú",
    "post it on X" to
        "đăng lên X",
    "put it in my note" to
        "đưa vào ghi chú của tôi",
    "technocore.chat did not take the change. It refuses writes when it is busy - press publish again in a moment. Your link is saved on this phone either way." to
        "technocore.chat không nhận thay đổi. Khi bận, nó từ chối ghi; hãy nhấn công bố lại sau một lát. Liên kết của bạn vẫn được lưu trên điện thoại này.",
    "vault: not sealed yet" to
        "két: chưa niêm phong",
    "vault: secure area" to
        "két: vùng an toàn",
    "vault: security chip" to
        "két: chip bảo mật",
    "vault: software" to
        "két: phần mềm",
    "with a wallet prefix - this Passport rebuilds only through this same wallet app" to
        "có tiền tố của ví — Passport này chỉ dựng lại được qua đúng ứng dụng ví này",
    "The prompt for this app begins with FLOP Passport key derivation v1 and names the app dev.alexkosa.floppassport; your wallet shows it was requested by flop.alexkosa.dev." to
        "Lời nhắc của ứng dụng này bắt đầu bằng FLOP Passport key derivation v1 và nêu tên ứng dụng dev.alexkosa.floppassport; ví của bạn cho thấy nó được yêu cầu bởi flop.alexkosa.dev.",

    // 2.0: FLOP account, my day, guide and questions (2026-11-03).
    "@flop_labs is FLOP's account on X, YouTube and TikTok." to
        "@flop_labs là tài khoản của FLOP trên X, YouTube và TikTok.",
    "A FLOP account with daily FLOP" to
        "Một tài khoản FLOP với FLOP hằng ngày",
    "A flop.finance address, but not one FLOP lists publicly. Ask through x.com/flop_labs." to
        "Một địa chỉ flop.finance, nhưng không phải địa chỉ FLOP công bố công khai. Hãy hỏi qua x.com/flop_labs.",
    "A flop.finance address. FLOP lists security@flop.finance as its one public contact." to
        "Một địa chỉ flop.finance. FLOP chỉ công bố một địa chỉ liên hệ công khai là security@flop.finance.",
    "A model you pay in FLOP, and a streak" to
        "Một mô hình bạn trả bằng FLOP, và một chuỗi ngày",
    "A practice network, open to everyone since 3 November 2026. FLOP here has no value, earns nothing and can be wiped in a reset. Use it to learn the day before it counts." to
        "Một mạng thực hành, mở cho mọi người từ ngày 3 tháng 11 năm 2026. FLOP ở đây không có giá trị, không mang lại gì và có thể bị xóa khi mạng được đặt lại. Hãy dùng nó để làm quen với việc hằng ngày trước khi nó được tính.",
    "A streak counts days in a row with a signed record. One missed day a week is now forgiven; two missed days in a row end it. The count is read from the public room, so a day you did not sign cannot be added later." to
        "Chuỗi ngày đếm số ngày liên tiếp có bản ghi đã ký. Giờ đây mỗi tuần được tha một ngày bỏ lỡ; bỏ lỡ hai ngày liên tiếp thì chuỗi kết thúc. Con số được đọc từ phòng công khai, nên một ngày bạn không ký thì không thể thêm vào sau.",
    "About 90 days. This is where FLOP's agent airdrop is earned: the testnet FLOP you spend on the model is recorded as your claim on mainnet FLOP." to
        "Khoảng 90 ngày. Đây là nơi airdrop dành cho tác nhân của FLOP được kiếm: số FLOP testnet bạn chi cho mô hình được ghi nhận là quyền nhận FLOP mainnet của bạn.",
    "Alex Kosa, one developer, for Seeker owners. It is not made by FLOP Labs. It is free and its code is open." to
        "Alex Kosa, một nhà phát triển, làm cho người dùng Seeker. Ứng dụng không do FLOP Labs làm. Nó miễn phí và mã nguồn mở.",
    "An identity made by your wallet" to
        "Một danh tính do ví của bạn tạo ra",
    "Ask a question, see what it cost, and keep a streak of the days you show up." to
        "Đặt một câu hỏi, xem nó tốn bao nhiêu, và giữ chuỗi những ngày bạn có mặt.",
    "Ask anything. The model is small, so short, plain questions work best. Each answer costs a few devnet FLOP, taken from your Passport's allowance." to
        "Hỏi gì cũng được. Mô hình nhỏ, nên câu hỏi ngắn và đơn giản là tốt nhất. Mỗi câu trả lời tốn vài FLOP devnet, trừ vào hạn mức của Passport.",
    "Ask the model" to
        "Hỏi mô hình",
    "Ask the model one question" to
        "Hỏi mô hình một câu",
    "Blocks are being finalised normally." to
        "Các khối đang được hoàn tất bình thường.",
    "Could not reach FLOP's gateway. Check your connection and try again." to
        "Không thể kết nối tới cổng của FLOP. Kiểm tra kết nối rồi thử lại.",
    "Could not reach technocore.chat." to
        "Không thể kết nối tới technocore.chat.",
    "Could not reach the FLOP devnet node. This says nothing about your balance, only about the connection." to
        "Không thể kết nối tới nút devnet của FLOP. Điều này không phản ánh số dư của bạn, chỉ phản ánh kết nối.",
    "Could not reach the FLOP explorer." to
        "Không thể kết nối tới trình khám phá của FLOP.",
    "Could not reach the FLOP faucet. Check your connection and try again." to
        "Không thể kết nối tới faucet của FLOP. Kiểm tra kết nối rồi thử lại.",
    "Devnet FLOP is practice money: it has no value and can be wiped in a reset." to
        "FLOP devnet là tiền thực hành: không có giá trị và có thể bị xóa khi mạng được đặt lại.",
    "Devnet explorer" to
        "Trình khám phá devnet",
    "Devnet is open" to
        "Devnet đã mở",
    "Devnet is open to everyone since 3 November 2026. It has no rewards and may be reset. Testnet has no date yet; FLOP will announce it on x.com/flop_labs. On testnet, the testnet FLOP an agent spends on inference becomes its claim on mainnet FLOP. Creating accounts earns nothing." to
        "Devnet mở cho mọi người từ ngày 3 tháng 11 năm 2026. Không có phần thưởng và có thể bị đặt lại. Testnet chưa có ngày; FLOP sẽ thông báo trên x.com/flop_labs. Trên testnet, số FLOP testnet mà một tác nhân chi cho suy luận sẽ trở thành quyền nhận FLOP mainnet của nó. Tạo tài khoản không mang lại gì.",
    "Devnet is practice" to
        "Devnet là để thực hành",
    "Devnet is practice: its FLOP has no value. This app promises nothing about any allocation." to
        "Devnet là để thực hành: FLOP trên đó không có giá trị. Ứng dụng này không hứa hẹn bất kỳ phân bổ nào.",
    "Do I have to post on X?" to
        "Tôi có phải đăng lên X không?",
    "Do I need more than one account?" to
        "Tôi có cần nhiều hơn một tài khoản không?",
    "Do my day" to
        "Hoàn tất hôm nay",
    "Every step below was read back from the server, not just sent." to
        "Mỗi bước dưới đây đều đã được đọc lại từ máy chủ, không chỉ được gửi đi.",
    "Explain the idea of a 'seed phrase' and why it must stay secret." to
        "Giải thích khái niệm 'cụm từ khôi phục' và vì sao phải giữ bí mật.",
    "Explain what 'decentralised' means without using jargon." to
        "Giải thích 'phi tập trung' nghĩa là gì mà không dùng thuật ngữ chuyên môn.",
    "Explain what a blockchain block is to a ten-year-old, in three sentences." to
        "Giải thích khối trong blockchain là gì cho một đứa trẻ mười tuổi, trong ba câu.",
    "Explain what an API is using a restaurant as the example." to
        "Giải thích API là gì, lấy nhà hàng làm ví dụ.",
    "Explain what open-source software is in two sentences." to
        "Giải thích phần mềm mã nguồn mở là gì trong hai câu.",
    "FLOP Network is a blockchain where AI agents pay for AI work with FLOP. Miners run models on graphics cards, validators check that the work was really done, and agents buy the answers. Asking the model a question here is exactly that: your Passport acts as an agent and pays for one answer." to
        "FLOP Network là một blockchain nơi các tác nhân AI trả tiền cho công việc AI bằng FLOP. Thợ đào chạy mô hình trên card đồ họa, trình xác thực kiểm tra công việc có thật sự được làm, và các tác nhân mua câu trả lời. Hỏi mô hình một câu ở đây chính là như vậy: Passport của bạn đóng vai một tác nhân và trả tiền cho một câu trả lời.",
    "FLOP Passport gives your Seeker an identity and an account on FLOP Network, and one place to do your day there. It is free, open source, and made by one developer, Alex Kosa. It is not made by FLOP Labs." to
        "FLOP Passport cho Seeker của bạn một danh tính và một tài khoản trên FLOP Network, cùng một nơi để hoàn tất việc hằng ngày ở đó. Ứng dụng miễn phí, mã nguồn mở và do một nhà phát triển, Alex Kosa, làm ra. Nó không do FLOP Labs làm.",
    "FLOP gives each account one devnet allowance: 25 FLOP for 24 hours. When it is over it is over until testnet." to
        "FLOP cho mỗi tài khoản một hạn mức devnet: 25 FLOP trong 24 giờ. Hết là hết, cho tới khi có testnet.",
    "FLOP has no Discord, Telegram, Reddit or Medium. There is no FLOP token yet." to
        "FLOP không có Discord, Telegram, Reddit hay Medium. Hiện chưa có token FLOP nào.",
    "FLOP has no official Discord, Telegram, Reddit or Medium. An invitation to one never comes from FLOP." to
        "FLOP không có Discord, Telegram, Reddit hay Medium chính thức. Lời mời vào những nơi đó không bao giờ đến từ FLOP.",
    "FLOP has not announced the testnet date. When it opens, the testnet FLOP you spend on the model becomes your claim on mainnet FLOP. Holding FLOP or making more accounts earns nothing." to
        "FLOP chưa công bố ngày testnet. Khi testnet mở, số FLOP testnet bạn chi cho mô hình sẽ trở thành quyền nhận FLOP mainnet của bạn. Giữ FLOP hay tạo thêm tài khoản không mang lại gì.",
    "FLOP has not given a date. It will be announced on x.com/flop_labs, and this app's status will say so the same day." to
        "FLOP chưa đưa ra ngày. Ngày sẽ được thông báo trên x.com/flop_labs, và trạng thái trong ứng dụng này sẽ báo ngay trong ngày đó.",
    "FLOP says Q1 2027" to
        "FLOP nói quý 1 năm 2027",
    "FLOP says there is no token, mint, claim, presale or live airdrop yet. Anything offering one is not FLOP." to
        "FLOP cho biết hiện chưa có token, mint, claim, bán trước hay airdrop nào đang diễn ra. Bất cứ thứ gì chào mời những điều đó đều không phải FLOP.",
    "FLOP's faucet is down for everyone right now. It is not your phone. Try again later." to
        "Faucet của FLOP hiện đang ngừng với tất cả mọi người. Không phải do điện thoại của bạn. Hãy thử lại sau.",
    "FLOP's faucet is refusing every request with “IP classification unavailable”. This is FLOP's bug (network issue #22), not your phone. The app keeps trying when you press do my day." to
        "Faucet của FLOP đang từ chối mọi yêu cầu với lỗi “IP classification unavailable”. Đây là lỗi của FLOP (lỗi network #22), không phải do điện thoại của bạn. Ứng dụng sẽ tiếp tục thử mỗi khi bạn bấm hoàn tất hôm nay.",
    "FLOP's faucet sends 25 devnet FLOP to your address, once every 24 hours per address. The request goes from your phone, for your own address, the same as pressing the button on faucet.flop.network. When the faucet is down, the app says so and the rest of your day still counts." to
        "Faucet của FLOP gửi 25 FLOP devnet tới địa chỉ của bạn, mỗi địa chỉ 24 giờ một lần. Yêu cầu được gửi từ điện thoại của bạn, cho chính địa chỉ của bạn, giống như bấm nút trên faucet.flop.network. Khi faucet ngừng hoạt động, ứng dụng sẽ báo và phần còn lại trong ngày của bạn vẫn được tính.",
    "FLOP's gateway has handed out all of today's devnet allowances, or is unavailable. Try again later." to
        "Cổng của FLOP đã phát hết hạn mức devnet hôm nay, hoặc đang không khả dụng. Hãy thử lại sau.",
    "FLOP's gateway rules (OpenAPI)" to
        "Quy tắc cổng của FLOP (OpenAPI)",
    "FLOP's only handle is @flop_labs. Any other account using the name is not theirs." to
        "Tên tài khoản duy nhất của FLOP là @flop_labs. Mọi tài khoản khác dùng tên này đều không phải của họ.",
    "FLOP: official links and verification" to
        "FLOP: liên kết chính thức và cách xác minh",
    "FLOP: the airdrop and testnet conversion" to
        "FLOP: airdrop và chuyển đổi từ testnet",
    "Faucet outage, FLOP issue #22" to
        "Faucet ngừng hoạt động, lỗi FLOP #22",
    "Finality is lagging behind. The network may be slow." to
        "Tính hoàn tất đang bị trễ. Mạng có thể chậm.",
    "Finish setting up your Passport first." to
        "Hãy hoàn tất thiết lập Passport trước.",
    "Free and open source. Made by Alex Kosa, not by FLOP Labs. It promises nothing about any allocation." to
        "Miễn phí và mã nguồn mở. Do Alex Kosa làm, không phải FLOP Labs. Ứng dụng không hứa hẹn bất kỳ phân bổ nào.",
    "From FLOP's faucet, once every 24 hours." to
        "Từ faucet của FLOP, 24 giờ một lần.",
    "From FLOP's faucet. Next in {time}." to
        "Từ faucet của FLOP. Lần tới sau {time}.",
    "From the FLOP Passport team, written into this version." to
        "Từ nhóm FLOP Passport, được viết sẵn trong phiên bản này.",
    "From the FLOP Passport team." to
        "Từ nhóm FLOP Passport.",
    "Get 25 FLOP" to
        "Nhận 25 FLOP",
    "Give me a short motivational sentence for a Monday." to
        "Cho tôi một câu ngắn tạo động lực cho ngày thứ Hai.",
    "Give me a simple recipe idea with rice and eggs." to
        "Gợi ý cho tôi một món đơn giản với cơm và trứng.",
    "Give me one practical tip for writing clearer emails." to
        "Cho tôi một mẹo thực tế để viết email rõ ràng hơn.",
    "Give one good question to ask before buying any crypto token." to
        "Đưa ra một câu hỏi nên đặt ra trước khi mua bất kỳ token tiền mã hóa nào.",
    "Give one way to remember a new word in a foreign language." to
        "Chỉ ra một cách để nhớ một từ mới trong ngoại ngữ.",
    "Give three tips for keeping a phone's battery healthy." to
        "Đưa ra ba mẹo giữ pin điện thoại khỏe.",
    "I changed phones. How do I get my Passport back?" to
        "Tôi đã đổi điện thoại. Làm sao lấy lại Passport?",
    "In plain words, what does 'inference' mean for an AI model?" to
        "Nói đơn giản, 'suy luận' nghĩa là gì đối với một mô hình AI?",
    "In two sentences, what does a GPU do that a CPU does badly?" to
        "Trong hai câu: GPU làm tốt việc gì mà CPU làm kém?",
    "Install the app and connect the same Solana wallet. The same wallet makes the same Passport, with the same FLOP address and the same streak. There are no words to write down." to
        "Cài ứng dụng và kết nối cùng ví Solana đó. Cùng một ví tạo ra cùng một Passport, với cùng địa chỉ FLOP và cùng chuỗi ngày. Không có từ nào cần ghi lại.",
    "Is this FLOP money real?" to
        "Số FLOP này có phải tiền thật không?",
    "It gets 25 devnet FLOP from FLOP's faucet every 24 hours." to
        "Nó nhận 25 FLOP devnet từ faucet của FLOP mỗi 24 giờ.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial: 25 FLOP for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "Trước hết cần có ít nhất 1 FLOP trong địa chỉ Passport của bạn. Trên devnet, mỗi tài khoản cũng chỉ có một lượt thử: 25 FLOP trong 24 giờ. Sau đó mô hình đóng cho tới khi có testnet. Thẻ Hỏi sẽ cho biết là trường hợp nào.",
    "Its FLOP has no value. What you practise here is what testnet will count." to
        "FLOP ở đó không có giá trị. Điều bạn luyện tập ở đây chính là điều testnet sẽ tính.",
    "Name three things to check before signing anything in a crypto wallet." to
        "Kể ra ba điều cần kiểm tra trước khi ký bất cứ thứ gì trong ví tiền mã hóa.",
    "Name three uses of AI that run well on small models." to
        "Kể ra ba ứng dụng AI chạy tốt trên mô hình nhỏ.",
    "No, and it would not help. FLOP counts spending, not accounts, and says extra accounts earn nothing. One person, one Passport." to
        "Không, và cũng chẳng giúp gì. FLOP tính mức chi tiêu, không tính số tài khoản, và cho biết tài khoản thêm không mang lại gì. Mỗi người, một Passport.",
    "No. Devnet FLOP is practice money with no value, and FLOP may wipe the devnet at any time. There is no FLOP token yet at all. Anybody selling FLOP today is a scammer." to
        "Không. FLOP devnet là tiền thực hành không có giá trị, và FLOP có thể xóa devnet bất cứ lúc nào. Hiện hoàn toàn chưa có token FLOP. Bất kỳ ai bán FLOP hôm nay đều là kẻ lừa đảo.",
    "No. Linking a post to your Passport is optional. It shows people the Passport is yours, nothing more." to
        "Không. Liên kết bài đăng với Passport là tùy chọn. Nó cho mọi người thấy Passport là của bạn, chỉ vậy thôi.",
    "Nobody can promise that, and this app never will. What FLOP says: on testnet, the testnet FLOP an agent spends on the model becomes its claim on mainnet FLOP. The app helps you do exactly that every day. Devnet, which is now, earns nothing." to
        "Không ai hứa được điều đó, và ứng dụng này sẽ không bao giờ hứa. Điều FLOP nói: trên testnet, số FLOP testnet mà một tác nhân chi cho mô hình sẽ trở thành quyền nhận FLOP mainnet của nó. Ứng dụng giúp bạn làm đúng việc đó mỗi ngày. Devnet, giai đoạn hiện nay, không mang lại gì.",
    "Nothing new to write down. The same wallet brings it back on any phone." to
        "Không có gì mới cần ghi lại. Cùng một ví sẽ khôi phục nó trên bất kỳ điện thoại nào.",
    "On devnet FLOP gives each account one allowance: 25 FLOP to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. When it is over, it stays over until testnet." to
        "Trên devnet, FLOP cho mỗi tài khoản một hạn mức: 25 FLOP để chi cho mô hình trong 24 giờ, và cần ít nhất 1 FLOP trong tài khoản để bắt đầu. Khi hết, nó sẽ hết cho tới khi có testnet.",
    "One button signs today, takes today's FLOP and asks the model one question." to
        "Một nút bấm sẽ ký hôm nay, nhận FLOP hôm nay và hỏi mô hình một câu.",
    "One press does all three, in order. Whatever is already done is skipped." to
        "Một lần bấm làm cả ba, theo thứ tự. Việc nào đã xong sẽ được bỏ qua.",
    "One question, paid in FLOP. Spending on the model is what testnet will count." to
        "Một câu hỏi, trả bằng FLOP. Điều testnet sẽ tính là số chi cho mô hình.",
    "One short text to sign. It is not a transaction and moves no money. Your wallet keeps its keys; nothing leaves it but that one signature." to
        "Một đoạn văn bản ngắn để ký. Đây không phải giao dịch và không chuyển tiền. Ví của bạn giữ khóa của nó; không có gì rời khỏi ví ngoài đúng một chữ ký đó.",
    "Only text, never a transaction. Once, to create your Passport. After that the Passport signs on its own: your daily record and the model's entry statement. None of it can move money from your wallet." to
        "Chỉ là văn bản, không bao giờ là giao dịch. Một lần, để tạo Passport. Sau đó Passport tự ký: bản ghi hằng ngày của bạn và tuyên bố để vào mô hình. Không thứ nào trong số đó có thể chuyển tiền khỏi ví của bạn.",
    "Open the app and press do my day. It signs today, takes today's FLOP from the faucet and asks the model one question. That is all. Whatever is already done is skipped." to
        "Mở ứng dụng và bấm hoàn tất hôm nay. Nó ký hôm nay, nhận FLOP hôm nay từ faucet và hỏi mô hình một câu. Chỉ vậy thôi. Việc nào đã xong sẽ được bỏ qua.",
    "Open the app and press do my day: it signs today, takes today's FLOP and asks the model one question." to
        "Mở ứng dụng và bấm hoàn tất hôm nay: nó ký hôm nay, nhận FLOP hôm nay và hỏi mô hình một câu.",
    "Paste a FLOP address from SubWallet, Talisman or Polkadot.js. The faucet will send there. The model still uses your Passport's own address, because only your Passport can sign for it." to
        "Dán một địa chỉ FLOP từ SubWallet, Talisman hoặc Polkadot.js. Faucet sẽ gửi tới đó. Mô hình vẫn dùng địa chỉ riêng của Passport, vì chỉ Passport mới ký được cho địa chỉ đó.",
    "Paste a full link, a handle like @name, or an address." to
        "Dán một liên kết đầy đủ, một tên tài khoản như @name, hoặc một địa chỉ.",
    "Paste a link, an @handle or an address someone sent you." to
        "Dán một liên kết, một tên @ hoặc một địa chỉ mà ai đó gửi cho bạn.",
    "Questions people ask" to
        "Những câu hỏi mọi người hay hỏi",
    "Reading your days from technocore.chat…" to
        "Đang đọc các ngày của bạn từ technocore.chat…",
    "Same Passport, same days. And now one missed day a week is forgiven." to
        "Cùng Passport, cùng những ngày đó. Và giờ đây mỗi tuần được tha một ngày bỏ lỡ.",
    "Sign today" to
        "Ký hôm nay",
    "Sign today to start your streak." to
        "Ký hôm nay để bắt đầu chuỗi ngày.",
    "Sign today's record" to
        "Ký bản ghi hôm nay",
    "Sign today, or the streak ends. Yesterday was already forgiven." to
        "Ký hôm nay, nếu không chuỗi sẽ kết thúc. Hôm qua đã được tha rồi.",
    "Signing the gateway's statement with your Passport…" to
        "Đang ký tuyên bố của cổng bằng Passport của bạn…",
    "Since 3 November FLOP's practice network is open to everyone. Devnet FLOP has no value, earns nothing, and the network may be reset at any time." to
        "Từ ngày 3 tháng 11, mạng thực hành của FLOP mở cho mọi người. FLOP devnet không có giá trị, không mang lại gì, và mạng có thể bị đặt lại bất cứ lúc nào.",
    "Staying safe" to
        "Giữ an toàn",
    "Suggest a five-minute stretch for someone who sits all day." to
        "Gợi ý một bài giãn cơ năm phút cho người ngồi cả ngày.",
    "Summarise what 'proof of work' means in two sentences." to
        "Tóm tắt 'bằng chứng công việc' (proof of work) nghĩa là gì trong hai câu.",
    "Take today's FLOP" to
        "Nhận FLOP hôm nay",
    "Tell me one interesting fact about the history of computers." to
        "Kể cho tôi một điều thú vị về lịch sử máy tính.",
    "Testnet and the airdrop" to
        "Testnet và airdrop",
    "Testnet: no date yet" to
        "Testnet: chưa có ngày",
    "That is not a FLOP address. It should start with 5 and be 47 or 48 characters; copy it again from your wallet." to
        "Đây không phải địa chỉ FLOP. Địa chỉ phải bắt đầu bằng 5 và dài 47 hoặc 48 ký tự; hãy sao chép lại từ ví của bạn.",
    "The faucet" to
        "Faucet",
    "The faucet did not answer." to
        "Faucet không phản hồi.",
    "The faucet is down for everyone" to
        "Faucet đang ngừng với mọi người",
    "The faucet sends to an address you chose instead:" to
        "Faucet đang gửi tới một địa chỉ khác mà bạn đã chọn:",
    "The faucet works for you" to
        "Faucet hoạt động với bạn",
    "The model did not answer." to
        "Mô hình không trả lời.",
    "The model is busy. Try again in a minute; nothing was spent." to
        "Mô hình đang bận. Thử lại sau một phút; chưa có gì bị chi.",
    "The model is closed for this account" to
        "Mô hình đã đóng với tài khoản này",
    "The model is thinking…" to
        "Mô hình đang suy nghĩ…",
    "The model needs at least 1 FLOP on your Passport address first. Get it from the faucet." to
        "Mô hình cần ít nhất 1 FLOP trong địa chỉ Passport của bạn trước đã. Hãy nhận từ faucet.",
    "The model: one trial per account" to
        "Mô hình: mỗi tài khoản một lượt thử",
    "The real token. There is no FLOP token before this, so anything sold or “claimed” as FLOP today is a scam." to
        "Token thật. Trước thời điểm này không có token FLOP nào, nên bất cứ thứ gì được bán hay “nhận” như FLOP hôm nay đều là lừa đảo.",
    "There is no FLOP token yet, so there is no FLOP contract address. Anything offered as one is not FLOP." to
        "Hiện chưa có token FLOP, nên cũng không có địa chỉ hợp đồng FLOP. Bất cứ thứ gì được giới thiệu như vậy đều không phải FLOP.",
    "There is no FLOP token yet. Nobody, including this app's author, will ever ask for your private key or your wallet's words. Your wallet only ever signs text here, never a transaction. If somebody sends you a FLOP link, check it on the Network tab first." to
        "Hiện chưa có token FLOP. Sẽ không có ai, kể cả tác giả ứng dụng này, hỏi bạn khóa riêng hay các từ khôi phục của ví. Ở đây ví của bạn chỉ ký văn bản, không bao giờ ký giao dịch. Nếu ai đó gửi cho bạn một liên kết FLOP, hãy kiểm tra ở thẻ Mạng trước.",
    "There is no Passport on this phone." to
        "Không có Passport nào trên điện thoại này.",
    "This account has used its one devnet allowance. FLOP does not renew it on devnet. The model opens again when testnet starts, and on testnet the FLOP you spend here is what counts." to
        "Tài khoản này đã dùng hết hạn mức devnet duy nhất. FLOP không cấp lại trên devnet. Mô hình sẽ mở lại khi testnet bắt đầu, và trên testnet, số FLOP bạn chi ở đây mới là thứ được tính.",
    "This account's devnet allowance is used up." to
        "Hạn mức devnet của tài khoản này đã hết.",
    "This address already got its FLOP in the last 24 hours." to
        "Địa chỉ này đã nhận FLOP trong 24 giờ qua.",
    "This app's source code" to
        "Mã nguồn của ứng dụng này",
    "This is an account on FLOP Network. An address alone says nothing about who holds it." to
        "Đây là một tài khoản trên FLOP Network. Chỉ riêng một địa chỉ không nói gì về người nắm giữ nó.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet that is 25 FLOP for 24 hours, once per account, and your account needs at least 1 FLOP to start it. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "Để dùng mô hình, Passport của bạn ký một tuyên bố ngắn từ api.flop.network. Chữ ký đó không chuyển gì cả. Sau đó FLOP mở một hạn mức cho tài khoản của bạn: trên devnet là 25 FLOP trong 24 giờ, mỗi tài khoản một lần, và tài khoản cần ít nhất 1 FLOP để bắt đầu. Một câu trả lời tốn khoảng 0,006 FLOP cho mỗi mảnh từ, thường là một hoặc hai FLOP. Khi hạn mức hết, mô hình sẽ đóng với tài khoản đó cho tới khi có testnet.",
    "Today is not signed yet" to
        "Hôm nay chưa được ký",
    "Today is not signed yet." to
        "Hôm nay chưa được ký.",
    "Today is signed. Come back tomorrow." to
        "Hôm nay đã ký. Mai quay lại nhé.",
    "Today is signed. See you tomorrow." to
        "Hôm nay đã ký. Hẹn gặp lại ngày mai.",
    "Too many tries from this network. Wait a minute and try again." to
        "Có quá nhiều lần thử từ mạng này. Đợi một phút rồi thử lại.",
    "Type a question" to
        "Nhập câu hỏi",
    "What FLOP is" to
        "FLOP là gì",
    "What FLOP says: on testnet, testnet FLOP that an agent actually spends on inference becomes its claim on mainnet FLOP. That claim is locked, and unlocks as it is spent on inference on mainnet: three spent unlock one. Holding FLOP earns nothing. Making more accounts earns nothing. Posting your identity earns nothing." to
        "Điều FLOP nói: trên testnet, số FLOP testnet mà một tác nhân thực sự chi cho suy luận sẽ trở thành quyền nhận FLOP mainnet của nó. Quyền này bị khóa, và được mở dần khi chi cho suy luận trên mainnet: chi ba thì mở một. Giữ FLOP không mang lại gì. Tạo thêm tài khoản không mang lại gì. Đăng danh tính của bạn không mang lại gì.",
    "What do I need to do every day?" to
        "Mỗi ngày tôi cần làm gì?",
    "What does a miner do in a compute network?" to
        "Thợ đào làm gì trong một mạng điện toán?",
    "What exactly does my wallet sign?" to
        "Chính xác thì ví của tôi ký cái gì?",
    "What is a hash function? Two sentences." to
        "Hàm băm là gì? Hai câu.",
    "What is a token in the context of language models?" to
        "Token là gì trong ngữ cảnh mô hình ngôn ngữ?",
    "What is a validator in a blockchain network? Keep it short." to
        "Trình xác thực trong mạng blockchain là gì? Trả lời ngắn.",
    "What is an AI agent, in one paragraph?" to
        "Tác nhân AI là gì, trong một đoạn văn?",
    "What is latency, and why do people care about it?" to
        "Độ trễ là gì, và vì sao mọi người quan tâm đến nó?",
    "What is phishing, and how do you spot it? Three signs." to
        "Lừa đảo phishing là gì, và làm sao nhận ra? Ba dấu hiệu.",
    "What is the cloud, really? Two sentences." to
        "Đám mây thực ra là gì? Hai câu.",
    "What is the difference between a private key and a public key?" to
        "Khóa riêng và khóa công khai khác nhau thế nào?",
    "What makes a password strong? Three short points." to
        "Điều gì làm nên một mật khẩu mạnh? Ba ý ngắn.",
    "What this app is" to
        "Ứng dụng này là gì",
    "What we say: this app promises nothing about any allocation, and never will. It helps you do, every day, the thing FLOP says it counts. One person, one Passport." to
        "Điều chúng tôi nói: ứng dụng này không hứa hẹn bất kỳ phân bổ nào và sẽ không bao giờ làm vậy. Nó giúp bạn làm, mỗi ngày, đúng điều mà FLOP nói là được tính. Mỗi người, một Passport.",
    "When does testnet start?" to
        "Khi nào testnet bắt đầu?",
    "Where FLOP is now" to
        "FLOP hiện đang ở đâu",
    "Where these facts come from" to
        "Những thông tin này lấy từ đâu",
    "Who made this app?" to
        "Ai làm ứng dụng này?",
    "Why did my streak go back to zero?" to
        "Vì sao chuỗi ngày của tôi về số không?",
    "Why do computers use binary? Two sentences." to
        "Vì sao máy tính dùng hệ nhị phân? Hai câu.",
    "Why does the model not answer me?" to
        "Vì sao mô hình không trả lời tôi?",
    "Why is my balance 0?" to
        "Vì sao số dư của tôi là 0?",
    "Will I get FLOP tokens for this?" to
        "Tôi có nhận được token FLOP nhờ việc này không?",
    "Write a haiku about a phone that never sleeps." to
        "Viết một bài haiku về chiếc điện thoại không bao giờ ngủ.",
    "You are a small model running on FLOP Network's devnet, answering inside a phone app. Answer briefly and plainly. Answer in the language the user writes in." to
        "Bạn là một mô hình nhỏ chạy trên devnet của FLOP Network, trả lời bên trong một ứng dụng điện thoại. Hãy trả lời ngắn gọn và dễ hiểu. Trả lời bằng ngôn ngữ mà người dùng viết.",
    "You never need this to recover: your wallet rebuilds the Passport. It is here for people who want to use their identity away from this phone. Nobody, including this app's author, will ever ask you for it." to
        "Bạn không bao giờ cần thứ này để khôi phục: ví của bạn sẽ dựng lại Passport. Nó ở đây cho những ai muốn dùng danh tính của mình ở nơi khác ngoài điện thoại này. Sẽ không có ai, kể cả tác giả ứng dụng này, hỏi bạn thứ này.",
    "Your FLOP address" to
        "Địa chỉ FLOP của bạn",
    "Your FLOP comes from FLOP's faucet, and right now the faucet is not giving FLOP to anyone. That is FLOP's problem, not your phone. When it works, press do my day and 25 FLOP arrives within a minute." to
        "FLOP của bạn đến từ faucet của FLOP, và hiện giờ faucet không cấp FLOP cho ai cả. Đó là vấn đề của FLOP, không phải của điện thoại bạn. Khi nó hoạt động lại, bấm hoàn tất hôm nay và 25 FLOP sẽ đến trong vòng một phút.",
    "Your Passport is a FLOP account" to
        "Passport của bạn là một tài khoản FLOP",
    "Your Passport is also a FLOP address. FLOP's faucet gives it 25 FLOP every 24 hours." to
        "Passport của bạn cũng là một địa chỉ FLOP. Faucet của FLOP cấp cho nó 25 FLOP mỗi 24 giờ.",
    "Your Passport key is also an account on FLOP Network. Same key, written the way FLOP writes addresses." to
        "Khóa Passport của bạn cũng là một tài khoản trên FLOP Network. Cùng một khóa, được viết theo cách FLOP viết địa chỉ.",
    "Your Passport key is also your FLOP account. It is the same key, written the way FLOP writes addresses, so there is nothing new to back up: your Solana wallet rebuilds both on any phone. If you already have a FLOP address in SubWallet, Talisman or Polkadot.js, you can send the faucet there instead, on the Passport tab. The model works only with the Passport's own address, because only the Passport can sign for it." to
        "Khóa Passport của bạn cũng chính là tài khoản FLOP của bạn. Đó là cùng một khóa, được viết theo cách FLOP viết địa chỉ, nên không có gì mới cần sao lưu: ví Solana của bạn dựng lại cả hai trên bất kỳ điện thoại nào. Nếu bạn đã có địa chỉ FLOP trong SubWallet, Talisman hoặc Polkadot.js, bạn có thể cho faucet gửi tới đó, ở thẻ Passport. Mô hình chỉ hoạt động với địa chỉ riêng của Passport, vì chỉ Passport mới ký được cho địa chỉ đó.",
    "Your Passport now lives on FLOP" to
        "Passport của bạn giờ đã có mặt trên FLOP",
    "Your Passport signs one line in public. It adds a day to your streak." to
        "Passport của bạn ký công khai một dòng. Việc đó thêm một ngày vào chuỗi.",
    "Your Passport signs one short line in a public room on technocore.chat, and the app reads it back to prove it landed. Each signed day adds to your streak. Miss one day and it is forgiven, once a week. Miss two in a row and the streak starts again." to
        "Passport của bạn ký một dòng ngắn trong một phòng công khai trên technocore.chat, và ứng dụng đọc lại để chứng minh nó đã tới nơi. Mỗi ngày đã ký được cộng vào chuỗi. Bỏ lỡ một ngày thì được tha, mỗi tuần một lần. Bỏ lỡ hai ngày liên tiếp thì chuỗi bắt đầu lại từ đầu.",
    "Your address got its FLOP from the faucet in the last 24 hours. It can ask again 24 hours after the last grant." to
        "Địa chỉ của bạn đã nhận FLOP từ faucet trong 24 giờ qua. Nó có thể xin lại sau 24 giờ kể từ lần cấp gần nhất.",
    "Your day is done." to
        "Ngày của bạn đã xong.",
    "Your day on FLOP, from your Seeker." to
        "Ngày của bạn trên FLOP, từ chiếc Seeker.",
    "Your day, step by step" to
        "Một ngày của bạn, từng bước",
    "Your first question opens it. Your Passport signs a short statement from api.flop.network; nothing else is signed and nothing moves. You need at least 1 FLOP on your Passport's address, which the faucet on Today gives you." to
        "Câu hỏi đầu tiên sẽ mở nó. Passport của bạn ký một tuyên bố ngắn từ api.flop.network; không có gì khác được ký và không có gì được chuyển đi. Bạn cần ít nhất 1 FLOP trong địa chỉ Passport, thứ mà faucet ở thẻ Hôm nay sẽ cấp cho bạn.",
    "Your identity note was deleted after seven quiet days. Publish it again to keep signing your days. Your streak is not lost." to
        "Ghi chú danh tính của bạn đã bị xóa sau bảy ngày im lặng. Hãy công bố lại để tiếp tục ký các ngày của bạn. Chuỗi ngày của bạn không mất.",
    "Your one devnet trial of the model is over. It opens again on testnet." to
        "Lượt thử mô hình duy nhất trên devnet của bạn đã hết. Nó sẽ mở lại trên testnet.",
    "Your streak came with you" to
        "Chuỗi ngày đã theo bạn sang đây",
    "Your wallet made this key and rebuilds it on any phone. There are no words to write down." to
        "Ví của bạn đã tạo khóa này và dựng lại nó trên bất kỳ điện thoại nào. Không có từ nào cần ghi lại.",
    "Your {n}-day streak ends at midnight" to
        "Chuỗi {n} ngày của bạn kết thúc lúc nửa đêm",
    "accounts" to
        "tài khoản",
    "active agents" to
        "tác nhân hoạt động",
    "all my records" to
        "mọi bản ghi của tôi",
    "allowance left" to
        "hạn mức còn lại",
    "already asked today" to
        "hôm nay đã hỏi rồi",
    "already signed today" to
        "hôm nay đã ký rồi",
    "already taken today" to
        "hôm nay đã nhận rồi",
    "answered" to
        "đã trả lời",
    "ask the model something else" to
        "hỏi mô hình điều khác",
    "back" to
        "quay lại",
    "balance" to
        "số dư",
    "balance {n} FLOP" to
        "số dư {n} FLOP",
    "change the address" to
        "đổi địa chỉ",
    "closes in" to
        "đóng sau",
    "compute market and FRCR index" to
        "thị trường điện toán và chỉ số FRCR",
    "copied" to
        "đã sao chép",
    "cost {n} FLOP" to
        "tốn {n} FLOP",
    "day in a row" to
        "ngày liên tiếp",
    "days in a row" to
        "ngày liên tiếp",
    "devnet flop" to
        "flop devnet",
    "do my day" to
        "hoàn tất hôm nay",
    "entering" to
        "đang vào",
    "finish your passport first" to
        "hoàn tất passport trước",
    "flop gateway" to
        "cổng flop",
    "go back to my passport address" to
        "quay về địa chỉ passport của tôi",
    "got it" to
        "đã hiểu",
    "how it all works" to
        "mọi thứ hoạt động thế nào",
    "how it works" to
        "cách hoạt động",
    "how it works, questions and answers" to
        "cách hoạt động, hỏi và đáp",
    "how the model works here" to
        "mô hình hoạt động thế nào ở đây",
    "is this really flop?" to
        "đây có thật là flop?",
    "just now" to
        "vừa xong",
    "latest block" to
        "khối mới nhất",
    "made by wallet" to
        "do ví tạo",
    "model" to
        "mô hình",
    "my day on flop" to
        "ngày của tôi trên flop",
    "needs flop" to
        "cần flop",
    "network" to
        "mạng",
    "new in 2.0" to
        "mới trong 2.0",
    "news" to
        "tin tức",
    "no date yet" to
        "chưa có ngày",
    "not entered" to
        "chưa vào",
    "not flop" to
        "không phải flop",
    "not flop's" to
        "không thuộc flop",
    "not now" to
        "để sau",
    "official" to
        "chính thức",
    "official channels" to
        "kênh chính thức",
    "open in FLOP's explorer" to
        "mở trong trình khám phá của FLOP",
    "private key" to
        "khóa riêng",
    "publish again" to
        "công bố lại",
    "read it in FLOP's own words" to
        "đọc bằng lời của chính FLOP",
    "reading" to
        "đang đọc",
    "refresh" to
        "làm mới",
    "refused" to
        "bị từ chối",
    "save" to
        "lưu",
    "scam warning" to
        "cảnh báo lừa đảo",
    "send" to
        "gửi",
    "settings, language, about" to
        "cài đặt, ngôn ngữ, giới thiệu",
    "signed and read back" to
        "đã ký và đọc lại",
    "spent on the model, as FLOP's explorer sees it" to
        "đã chi cho mô hình, theo trình khám phá của FLOP",
    "start" to
        "bắt đầu",
    "the proof" to
        "bằng chứng",
    "to do" to
        "cần làm",
    "today" to
        "hôm nay",
    "today's question: {q}" to
        "câu hỏi hôm nay: {q}",
    "trial over" to
        "hết lượt thử",
    "use an address I already have" to
        "dùng địa chỉ tôi đã có",
    "validators" to
        "trình xác thực",
    "what is happening now" to
        "hiện đang diễn ra gì",
    "what your wallet will show" to
        "ví của bạn sẽ hiển thị gì",
    "where flop stands" to
        "flop đang ở đâu",
    "your flop address" to
        "địa chỉ flop của bạn",
    "{day} was missed and forgiven: one missed day a week is." to
        "{day} đã bị bỏ lỡ và được tha: mỗi tuần được tha một ngày bỏ lỡ.",
    "{h} h {m} min" to
        "{h} giờ {m} phút",
    "{m} min" to
        "{m} phút",
    "{n} d ago" to
        "{n} ngày trước",
    "{n} h ago" to
        "{n} giờ trước",
    "{n} min ago" to
        "{n} phút trước",
    "Today" to "Hôm nay",
    "Ask" to "Hỏi",
    "Network" to "Mạng",
    "{host} is on FLOP's official list." to "{host} có trong danh sách chính thức của FLOP.",
    "This is FLOP's own account on {host}." to "Đây là tài khoản của chính FLOP trên {host}.",
    "This is on {host}, but not FLOP's account there. FLOP's is {account}." to "Đây là {host}, nhưng không phải tài khoản của FLOP ở đó. Tài khoản của FLOP là {account}.",
    "{host} uses the FLOP name but is not on FLOP's official list. Treat it as an impersonation." to "{host} dùng tên FLOP nhưng không có trong danh sách chính thức của FLOP. Hãy coi đó là giả mạo.",
    "{host} is not FLOP. That does not make it bad, only not FLOP." to "{host} không phải FLOP. Điều đó không có nghĩa là xấu, chỉ là không phải FLOP.",
    // The faucet came back (2026-11-03).
    "The faucet works" to
        "Vòi đang hoạt động",
    "FLOP's faucet gives each address 25 FLOP once every 24 hours. It can be slow: an answer may take a minute or two. The app waits for it and checks your balance." to
        "Vòi của FLOP cho mỗi địa chỉ 25 FLOP mỗi 24 giờ một lần. Vòi có thể chậm: một phản hồi có thể mất một hai phút. Ứng dụng sẽ chờ và kiểm tra số dư của bạn.",
    "Your FLOP comes from FLOP's faucet: 25 FLOP once every 24 hours. Press do my day and wait, the faucet can take a minute or two. If the balance stays 0, the faucet step says why." to
        "FLOP của bạn đến từ vòi của FLOP: 25 FLOP mỗi 24 giờ một lần. Nhấn “hoàn tất hôm nay” và chờ, vòi có thể mất một hai phút. Nếu số dư vẫn là 0, bước vòi sẽ ghi lý do.",
    // Review fixes before the 2.0 release (2026-11-03).
    "The faucet is limiting requests from your network right now. Nothing arrived; try again later." to
        "Vòi đang giới hạn yêu cầu từ mạng của bạn. Chưa có gì đến; hãy thử lại sau.",
    "FLOP's gateway sent a sign-in text this app does not recognise, so it was not signed. Nothing happened." to
        "Cổng của FLOP gửi một đoạn văn bản đăng nhập mà ứng dụng không nhận ra, nên đã không ký. Không có gì xảy ra.",
    "The faucet said no: {reason}" to
        "Vòi đã từ chối: {reason}",
    "The gateway said no: {reason}" to
        "Cổng đã từ chối: {reason}",
    "The model did not answer: {reason}" to
        "Mô hình không trả lời: {reason}",
    "Only https links can be FLOP's. Type FLOP's address yourself instead of following this one." to
        "Chỉ liên kết https mới có thể là của FLOP. Hãy tự gõ địa chỉ của FLOP thay vì mở liên kết này.",
    "Sign today to keep your streak. This week's one forgiven day is already used." to
        "Hãy ký hôm nay để giữ chuỗi. Ngày được bỏ qua duy nhất của tuần này đã dùng rồi.",
    // The model allowance is what the gateway says, not a fixed number (2026-11-03).
    "On devnet FLOP gives each account one allowance to spend on the model within 24 hours, and needs at least 1 FLOP on the account to start it. The Ask tab shows how much is left. When it is over, it stays over until testnet." to
        "Trên devnet, FLOP cho mỗi tài khoản một hạn mức để dùng mô hình trong 24 giờ, và tài khoản cần ít nhất 1 FLOP để bắt đầu. Thẻ Hỏi cho biết còn lại bao nhiêu. Khi hết, mô hình đóng đến testnet.",
    "FLOP gives each account one devnet allowance for 24 hours. The figure above is what is left of it. When it is over it is over until testnet." to
        "FLOP cho mỗi tài khoản một hạn mức devnet trong 24 giờ. Con số ở trên là phần còn lại. Khi hết, mô hình đóng đến testnet.",
    "It needs at least 1 FLOP on your Passport address first. On devnet each account also gets only one trial, for 24 hours. After that it stays closed until testnet. The Ask tab says which one it is." to
        "Trước hết địa chỉ Passport của bạn cần ít nhất 1 FLOP. Ngoài ra trên devnet mỗi tài khoản chỉ có một lần dùng thử, trong 24 giờ. Sau đó mô hình đóng đến testnet. Thẻ Hỏi cho biết là trường hợp nào.",
    "To use the model, your Passport signs a short statement from api.flop.network. That signature moves nothing. FLOP then opens an allowance for your account: on devnet one, for 24 hours, and your account needs at least 1 FLOP to start it. The Ask tab shows how much of it is left. An answer costs about 0.006 FLOP per word-piece, usually one or two FLOP. When the allowance ends, the model stays closed for that account until testnet." to
        "Để dùng mô hình, Passport của bạn ký một tuyên bố ngắn từ api.flop.network. Chữ ký đó không chuyển đi gì cả. Sau đó FLOP mở một hạn mức cho tài khoản của bạn: trên devnet là một, trong 24 giờ, và tài khoản cần ít nhất 1 FLOP để bắt đầu. Thẻ Hỏi cho biết còn lại bao nhiêu. Mỗi mẩu từ tốn khoảng 0,006 FLOP, một câu trả lời thường một hai FLOP. Khi hạn mức kết thúc, mô hình đóng với tài khoản đó đến testnet.",
    // The faucet's two other refusals, seen 3-4 November 2026.
    "The faucet has your request in its queue and has not sent the FLOP yet. This can take a while. Press do my day again later." to
        "Yêu cầu của bạn đang trong hàng đợi của vòi và FLOP chưa được gửi. Việc này có thể mất một lúc. Hãy nhấn “hoàn tất hôm nay” lại sau.",
    "The faucet has given out all of today's FLOP. Nothing arrived. It opens again within hours, so try later." to
        "Vòi đã phát hết FLOP của hôm nay. Chưa có gì đến. Vòi sẽ mở lại trong vài giờ, hãy thử sau.",
    "Signing today's line with your Passport and reading it back from technocore.chat…" to
        "Đang ký dòng hôm nay bằng Passport của bạn và đọc lại từ technocore.chat…",
    "Asking FLOP's faucet. It serves about 10 people a minute, so this can take up to 2 minutes." to
        "Đang hỏi faucet của FLOP. Faucet phục vụ khoảng 10 người mỗi phút nên có thể mất đến 2 phút.",
    "You are in the faucet's queue. The app watches your balance and asks again by itself." to
        "Bạn đang trong hàng đợi của faucet. Ứng dụng theo dõi số dư và tự hỏi lại.",
    "Reading your balance…" to
        "Đang đọc số dư…",
    "Sending your question to the model. It has up to 90 seconds to answer." to
        "Đang gửi câu hỏi tới mô hình. Mô hình có tối đa 90 giây để trả lời.",
    "FLOP's gateway is full right now: many people are asking at once. Nothing was spent. The app tries again by itself." to
        "Cổng của FLOP đang đầy: nhiều người hỏi cùng lúc. Chưa tốn gì. Ứng dụng tự thử lại.",
    "Your FLOP is still settling on the network. The app tries again by itself." to
        "FLOP của bạn vẫn đang được xác nhận trên mạng. Ứng dụng tự thử lại.",
    "Reading what the answer cost…" to
        "Đang đọc chi phí của câu trả lời…",
    "FLOP's gateway stayed full through every try. Nothing was spent. Try again in a few minutes." to
        "Cổng của FLOP vẫn đầy trong mọi lần thử. Chưa tốn gì. Hãy thử lại sau vài phút.",
    "{n} s so far" to
        "đã qua {n} giây",
    "try {n} of {m}" to
        "lần thử {n}/{m}",
    "next try in {n} s" to
        "lần thử tiếp sau {n} giây",
    "gateway ping {n} ms" to
        "ping cổng {n} ms",
    "faucet ping {n} ms" to
        "ping faucet {n} ms",
    "the gateway does not answer a ping" to
        "cổng không trả lời ping",
    "the faucet does not answer a ping" to
        "faucet không trả lời ping",
    "step {n} of 3" to
        "bước {n}/3",
    "ping" to
        "ping",
    "no answer" to
        "không có phản hồi",
    "last answer took" to
        "câu trả lời gần nhất mất",
    "You can leave this screen: it keeps going." to
        "Bạn có thể rời màn hình này: việc vẫn tiếp tục.",
    "Signing today's line" to
        "Đang ký dòng của hôm nay",
    "Your Passport signs one short line in the public room and reads it back. That line is your day." to
        "Passport của bạn ký một dòng ngắn trong phòng công khai rồi đọc lại. Dòng đó chính là ngày của bạn.",
    "Asking FLOP's faucet" to
        "Đang hỏi faucet của FLOP",
    "The faucet pays about 10 people a minute. This can take up to two minutes." to
        "Faucet trả cho khoảng 10 người mỗi phút. Việc này có thể mất tới hai phút.",
    "Standing in the faucet's queue" to
        "Đang xếp hàng ở faucet",
    "The faucet pays about 10 people a minute. Your request is in. We watch your balance and ask again by ourselves." to
        "Faucet trả cho khoảng 10 người mỗi phút. Yêu cầu của bạn đã vào hàng. Chúng tôi theo dõi số dư và tự hỏi lại.",
    "Your FLOP is on its way" to
        "FLOP của bạn đang trên đường tới",
    "One moment." to
        "Chờ một chút.",
    "Opening the model" to
        "Đang mở mô hình",
    "Your Passport signs the gateway's statement. Nothing is spent." to
        "Passport của bạn ký bản tuyên bố của cổng. Không tốn gì cả.",
    "Asking the model" to
        "Đang hỏi mô hình",
    "Your question is with the model. It has up to 90 seconds." to
        "Câu hỏi của bạn đang ở chỗ mô hình. Mô hình có tối đa 90 giây.",
    "The model is full right now" to
        "Mô hình đang đầy",
    "Many people are asking at once. Nothing was spent. We try again by ourselves." to
        "Nhiều người đang hỏi cùng lúc. Không tốn gì cả. Chúng tôi tự thử lại.",
    "Your FLOP is still settling" to
        "FLOP của bạn vẫn đang được ghi nhận",
    "A fresh grant takes a moment to count. We try again by ourselves." to
        "Khoản mới cần một lát để được tính. Chúng tôi tự thử lại.",
    "Reading what it cost" to
        "Đang đọc chi phí",
    "FLOP's gateway stayed full through all 6 tries. Nothing was spent. This is on FLOP's side, not yours." to
        "Cổng của FLOP đầy suốt cả 6 lần thử. Không tốn gì cả. Đây là phía FLOP, không phải phía bạn.",
    "to next try" to
        "đến lần thử tiếp",
    "elapsed {t}" to
        "đã qua {t}",
    "ask the model" to
        "hỏi mô hình",
    "Answered" to
        "Đã có câu trả lời",
    "cost {c} FLOP · {s} s" to
        "chi phí {c} FLOP · {s} giây",
    "The model did not answer" to
        "Mô hình không trả lời",
    "your question" to
        "câu hỏi của bạn",
    "waiting" to
        "đang chờ",
    "Connect your Passport" to
        "Kết nối Passport của bạn",
    "Get the answer" to
        "Nhận câu trả lời",
    "minimise · it keeps going" to
        "thu nhỏ · vẫn tiếp tục chạy",
    "my day · step {n} of 3" to
        "hôm nay của tôi · bước {n}/3",
    "my day" to
        "hôm nay của tôi",
    "Your day is closed" to
        "Ngày của bạn đã đóng",
    "See you tomorrow." to
        "Hẹn mai gặp lại.",
    "Today is signed" to
        "Hôm nay đã ký",
    "not today" to
        "không phải hôm nay",
    "Could not sign today" to
        "Không thể ký hôm nay",
    "Your day is signed. Your streak of {n} is safe whatever happens next." to
        "Ngày của bạn đã ký. Chuỗi {n} ngày của bạn an toàn dù có chuyện gì.",
    "Today is not signed yet. One missed day a week is forgiven; two in a row end the streak." to
        "Hôm nay chưa ký. Mỗi tuần được bỏ qua một ngày; bỏ lỡ hai ngày liên tiếp thì chuỗi kết thúc.",
    "question of the day: {q}" to
        "câu hỏi của ngày: {q}",
    "Part of your day waits" to
        "Một phần ngày của bạn đang chờ",
    "passport · {name}" to
        "passport · {name}",
    "Days in a row: {n}" to
        "Số ngày liên tiếp: {n}",
    "Start your streak today" to
        "Bắt đầu chuỗi ngày từ hôm nay",
    "Registered {date} · day {n} with us" to
        "Đăng ký {date} · ngày thứ {n} cùng chúng tôi",
    "reading your days" to
        "đang đọc các ngày của bạn",
    "today signed" to
        "hôm nay đã ký",
    "sign today or the streak ends" to
        "ký hôm nay, nếu không chuỗi sẽ dừng",
    "today not signed yet" to
        "hôm nay chưa ký",
    "in a row" to
        "liên tiếp",
    "{n} of 3" to
        "{n}/3",
    "Your Passport signs one public line. That line is your streak." to
        "Passport của bạn ký một dòng công khai. Dòng đó chính là chuỗi ngày của bạn.",
    "From FLOP's faucet, once a day. Practice coins, no price." to
        "Từ faucet của FLOP, mỗi ngày một lần. Xu luyện tập, không có giá.",
    "One question of the day, paid in FLOP." to
        "Một câu hỏi mỗi ngày, trả bằng FLOP.",
    "One press, all three steps in order. What is already done is skipped." to
        "Một lần bấm, cả ba bước theo thứ tự. Việc đã xong sẽ được bỏ qua.",
    "devnet · practice network" to
        "devnet · mạng luyện tập",
    "one key · two networks" to
        "một khóa · hai mạng",
    "Seeker wallet" to
        "Ví Seeker",
    "Made the Passport with one signature. Brings it back on any phone." to
        "Đã tạo Passport bằng một chữ ký. Khôi phục lại trên bất kỳ điện thoại nào.",
    "FLOP account" to
        "Tài khoản FLOP",
    "The same key as a FLOP address. The faucet pays here; the model is paid from here." to
        "Cùng một khóa, dưới dạng địa chỉ FLOP. Faucet trả vào đây; mô hình được trả từ đây.",
    "Registered" to
        "Đã đăng ký",
    "Days in a row" to
        "Số ngày liên tiếp",
    "Best streak" to
        "Chuỗi dài nhất",
    "Signed days" to
        "Số ngày đã ký",
    "Balance, FLOP" to
        "Số dư, FLOP",
    "Spent on the model, FLOP" to
        "Đã chi cho mô hình, FLOP",
    "1 skip left this week" to
        "còn 1 lần bỏ qua tuần này",
    "this week's skip is used" to
        "lần bỏ qua tuần này đã dùng",
    "details and key" to
        "chi tiết và khóa",
    "On Seeker · in FLOP Network · an app by Alex Kosa, not FLOP Labs, not Solana Mobile" to
        "Trên Seeker · trong mạng FLOP · ứng dụng của Alex Kosa, không phải của FLOP Labs hay Solana Mobile",
    "days signed together" to
        "số ngày cùng nhau ký",
    "flop pulse" to
        "nhịp flop",
    "Devnet is a practice network, open to everyone since 3 November. Coins have no price, there is no reward." to
        "Devnet là mạng luyện tập, mở cho mọi người từ ngày 3 tháng 11. Xu không có giá và không có phần thưởng.",
    "more about the network" to
        "thêm về mạng",
    "thanks to both sides" to
        "cảm ơn cả hai phía",
    "for Seeker, the wallet and one-tap signing" to
        "vì Seeker, chiếc ví và việc ký chỉ bằng một chạm",
    "for the network, the faucet and a model you can pay" to
        "vì mạng, faucet và một mô hình có thể trả tiền",
    "An independent app by Alex Kosa. No promises about tokens or rewards." to
        "Một ứng dụng độc lập của Alex Kosa. Không hứa hẹn gì về token hay phần thưởng.",
    "check a link, an @name or an address someone sent you" to
        "kiểm tra một liên kết, một @tên hoặc một địa chỉ ai đó gửi cho bạn",
    "check" to
        "kiểm tra",
    "FLOP model" to
        "Mô hình FLOP",
    "The model is small: short, plain questions work best. Everything you pay is practice FLOP." to
        "Mô hình nhỏ: câu hỏi ngắn, đơn giản cho kết quả tốt nhất. Mọi thứ bạn trả đều là FLOP luyện tập.",
    "model open" to
        "mô hình mở",
    "opening the model" to
        "đang mở mô hình",
    "trial over for this account" to
        "đã hết dùng thử cho tài khoản này",
    "needs 1 flop" to
        "cần 1 flop",
    "model closed for now" to
        "mô hình tạm đóng",
    "first question opens it" to
        "câu hỏi đầu tiên sẽ mở nó",
    "ping {n} ms" to
        "ping {n} ms",
    "Your Passport signs a short statement from FLOP's gateway. Nothing moves. You need at least 1 FLOP; the faucet on Today gives you 25." to
        "Passport của bạn ký một bản tuyên bố ngắn của cổng FLOP. Không có gì được chuyển đi. Bạn cần ít nhất 1 FLOP; faucet ở mục Hôm nay cho bạn 25.",
    "more" to
        "thêm",
    "That was the last step. Your Passport is live, and your day on FLOP starts now." to
        "Đó là bước cuối. Passport của bạn đã sẵn sàng, và ngày của bạn trên FLOP bắt đầu từ bây giờ.",
    "Pulse" to
        "Nhịp",
    "Who is here, and how FLOP's network is doing today." to
        "Ai đang ở đây và mạng FLOP hôm nay thế nào.",
    "who is here" to
        "ai đang ở đây",
    "Passport holders" to
        "người có Passport",
    "{n} Passport holders · {m} signed today" to
        "Người có Passport: {n} · hôm nay đã ký: {m}",
    "{n} of them signed today" to
        "trong đó hôm nay đã ký: {n}",
    "To keep a streak, each holder signs one short public line a day. Counted from that public record, so anyone can repeat it." to
        "Để giữ chuỗi, mỗi người ký một dòng công khai ngắn mỗi ngày. Đếm từ bản ghi công khai đó, ai cũng có thể kiểm tra lại.",
    "same key" to
        "cùng một khóa",
    "knock now" to
        "gõ cửa ngay",
    "A refused knock costs nothing. Knock as often as you like." to
        "Bị từ chối không mất gì. Gõ bao nhiêu lần tùy bạn.",
    "FLOP spent on the model, all time" to
        "FLOP đã chi cho mô hình, tổng cộng",
    "accounts that paid for the model" to
        "tài khoản đã trả cho mô hình",
    "Join FLOP with Alex's link" to
        "Vào FLOP bằng liên kết của Alex",
    "This is Alex Kosa's personal referral link from FLOP, and it may count for him. It gives you nothing extra from this app. Prefer not to? Go to flop.finance yourself." to
        "Đây là liên kết giới thiệu cá nhân của Alex Kosa từ FLOP và có thể được tính cho anh ấy. Ứng dụng này không cho bạn thêm gì. Không muốn dùng? Hãy tự vào flop.finance.",
    "open {host}" to
        "mở {host}",
)
