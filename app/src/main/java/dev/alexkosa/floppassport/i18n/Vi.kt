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
    "06  last step" to "06  bước cuối",
    "06  tell them" to "06  kể cho mọi người",
    "06  tell them  ·  last step" to "06  kể cho mọi người  ·  bước cuối",
    "5 of 6" to "5 trên 6",
    "A few more words, and it is yours. One real sentence is all this needs." to
        "Thêm vài chữ nữa là xong. Chỉ cần một câu thật.",
    "A few reminders about the last step, and then they stop." to
        "Vài lời nhắc về bước cuối, rồi sẽ thôi.",
    "A little too long. Trim it and the whole post fits, key included." to
        "Hơi dài. Rút ngắn lại là cả bài vừa đủ, kể cả khóa.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Một tin nhắn được Passport của bạn ký, gửi vào một phòng yên tĩnh rồi đọc lại để chứng minh đã được ghi nhận.",
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed. Same service as step 03, same rule: if it refuses, press again. It is their load, not your key." to
        "Một tin nhắn do Passport của bạn ký, đăng vào một phòng yên tĩnh rồi đọc ngược lại để chứng minh nó đã tới. Cùng dịch vụ với bước 03, cùng một quy tắc: bị từ chối thì bấm lại. Đó là tải của họ, không phải khóa của bạn.",
    "A once-a-day reminder to leave today's signed record." to
        "Lời nhắc mỗi ngày một lần để để lại bản ghi đã ký hôm nay.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Một ghi chú lâu dài tại địa chỉ được tạo từ khóa của bạn, để sau này bất kỳ ai cũng có thể tìm và xác minh bạn.",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "Một ghi chú công khai tại địa chỉ được dẫn xuất từ khóa của bạn, để bất kỳ ai cũng có thể tìm và xác minh bạn sau này.",
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
    "All five done" to "Xong cả năm bước",
    "All six done" to "Xong cả sáu bước",
    "Already checked in, found in the room" to "Đã ghi bản ghi, đã tìm thấy trong phòng",
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
    "Check in" to "Ghi bản ghi",
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
    "Created my FLOP Passport on a Solana Seeker." to
        "Đã tạo FLOP Passport của tôi trên Solana Seeker.",
    "Daily activity" to "Hoạt động hằng ngày",
    "Daily reminder" to "Lời nhắc hằng ngày",
    "Delete it?" to "Xóa mục này?",
    "Delete the Passport and create it again from your wallet." to
        "Xóa Passport rồi tạo lại từ ví của bạn.",
    "Deleted after seven days without a record. Sign one now and it goes back to the same address." to
        "Đã bị xóa sau bảy ngày không có bản ghi. Hãy ký một bản ghi ngay và ghi chú sẽ trở lại cùng một địa chỉ.",
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Việc xóa chỉ gỡ Passport khỏi điện thoại này. Mọi nội dung đã công bố có thể vẫn công khai, và cùng một ví sẽ tạo lại cùng một danh tính - vì vậy đây không phải là cách hoàn tác bất kỳ điều gì.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Thao tác xóa chỉ gỡ Passport khỏi điện thoại này. Mọi nội dung đã công bố vẫn công khai và cùng ví đó sẽ dựng lại cùng một danh tính - vì vậy đây không phải cách hoàn tác.",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Được dẫn xuất từ chữ ký Seed Vault, rồi được StrongBox niêm phong trên thiết bị.",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "Được dẫn xuất từ chữ ký mà ví của tôi tạo trong Seed Vault, rồi được StrongBox niêm phong.",
    "Did you post it?" to "Bạn đã đăng chưa?",
    "Every language listed here has a full translation." to
        "Mọi ngôn ngữ được liệt kê ở đây đều có bản dịch đầy đủ.",
    "FLOP Passport creates a Technocore identity from your Solana wallet and keeps the receipts." to
        "FLOP Passport tạo danh tính Technocore từ ví Solana của bạn và lưu các biên nhận.",
    "FLOP Passport for Seeker" to "FLOP Passport cho Seeker",
    "FLOP Passport for Seeker - private backup" to
        "FLOP Passport cho Seeker - bản sao lưu riêng tư",
    "FLOP Passport for Seeker by @AlexKosa1" to "FLOP Passport cho Seeker, bởi @AlexKosa1",
    "FLOP Passport for Seeker. First signed check-in." to
        "FLOP Passport cho Seeker. Bản ghi đầu tiên đã được ký.",
    "FLOP asked agents to do something useful. A signed record is how you leave evidence of it, and a day without one is a day nobody can check later." to
        "FLOP yêu cầu các tác nhân làm điều gì đó hữu ích. Bản ghi có ký là dấu vết bạn để lại cho việc đó, còn một ngày không có bản ghi là một ngày sau này không ai kiểm được.",
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP yêu cầu các tác nhân làm điều gì đó hữu ích. Bản ghi đã ký là bằng chứng cho việc đó, và nếu một ngày không có bản ghi thì sau này không ai có thể kiểm tra ngày đó.",
    "FLOP asked agents to do two things: create a unique key, and do something useful to spread the word about Technocore. The five steps above did the first. Nobody can do the second for you, so this writes the post and you decide whether to send it." to
        "FLOP yêu cầu các trợ lý làm hai việc: tạo một khóa duy nhất và làm điều gì đó hữu ích để lan truyền thông tin về Technocore. Năm bước trên đã hoàn thành việc đầu tiên. Không ai có thể làm việc thứ hai thay bạn, nên ứng dụng sẽ viết bài đăng và bạn quyết định có gửi hay không.",
    "Identity derived from your wallet signature" to "Danh tính được tạo từ chữ ký ví của bạn",
    "Identity note published, first check in signed and verified on Technocore." to
        "Đã công bố ghi chú danh tính, bản ghi đầu tiên đã được ký và xác minh trên Technocore.",
    "Identity note published, first check in verified on Technocore." to
        "Đã công bố ghi chú danh tính, bản ghi đầu tiên đã được xác minh trên Technocore.",
    "Identity note published, first check in verified." to
        "Đã công bố ghi chú danh tính, bản ghi đầu tiên đã được xác minh.",
    "If it does get deleted, your Passport is not gone: the same wallet still gives the same identity, and signing a record publishes the note back to the same address." to
        "Nếu ghi chú bị xóa, Passport của bạn vẫn không mất: cùng một ví vẫn tạo ra cùng một danh tính, và việc ký một bản ghi sẽ đăng lại ghi chú tại cùng một địa chỉ.",
    "In one line: what you did, or why you set this up" to
        "Một dòng thôi: bạn đã làm gì, hoặc vì sao bạn lập cái này",
    "It never asks for your wallet recovery phrase." to
        "Ứng dụng không bao giờ yêu cầu cụm từ khôi phục ví của bạn.",
    "It promises nothing about any airdrop, and never will." to
        "Ứng dụng không hứa hẹn gì về bất kỳ airdrop nào và sẽ không bao giờ làm vậy.",
    "It will be deleted after seven days without a record." to
        "Ghi chú sẽ bị xóa sau bảy ngày không có bản ghi.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Giữ tệp này ngoại tuyến. Không bao giờ gửi cho bất kỳ ai, kể cả tác giả ứng dụng.",
    "Keep your record going" to "Duy trì bản ghi của bạn",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Khóa được tạo trong Seed Vault, rồi niêm phong bằng StrongBox trên thiết bị.",
    "Language" to "Ngôn ngữ",
    "Last reminder about this one." to "Đây là lời nhắc cuối về việc này.",
    "Leave it blank and the post still works. It just says less." to
        "Để trống thì bài đăng vẫn dùng được. Chỉ là ít thông tin hơn.",
    "Leave today's signed record on Technocore." to
        "Để lại bản ghi đã ký hôm nay trên Technocore.",
    "Link to what you built, if there is one" to "Liên kết đến thứ bạn đã tạo, nếu có",
    "Link to your post" to "Liên kết đến bài đăng của bạn",
    "Make your first signed check-in" to "Tạo bản ghi có chữ ký đầu tiên",
    "My FLOP Passport, created on a Solana Seeker." to
        "FLOP Passport của tôi, được tạo trên Solana Seeker.",
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
    "Not finished yet. Until all five are green your identity is not published and there is nothing anyone can verify. Keep going." to
        "Vẫn chưa xong. Chừng nào cả năm chưa xanh thì danh tính của bạn chưa được công bố và không ai kiểm chứng được gì cả. Cứ tiếp tục.",
    "Nothing asked yet" to "Chưa có câu hỏi nào",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Không tìm thấy gì. Nếu bạn đã ký nội dung nhưng không thấy ở đây, phòng đã lược bỏ phần chứa nội dung đó - đây là điều bình thường và chính là lý do màn hình này tồn tại.",
    "Nothing has vouched for this text yet. Publish again to sign for it." to
        "Chưa có gì bảo chứng cho nội dung này. Hãy đăng lại để ký cho nó.",
    "Nothing is broken and nothing is lost. Your Passport works. When you want the public half of it, step 06 is waiting where you left it." to
        "Không có gì hỏng và không mất gì cả. Passport của bạn vẫn chạy. Khi nào bạn muốn nửa công khai của nó, bước 06 vẫn ở chỗ bạn để lại.",
    "Nothing signed today yet." to "Hôm nay chưa có nội dung nào được ký.",
    "One sentence in your own words, please. Thousands of posts that differ only by a key get read as farming, and that lands on the people who did the work." to
        "Hãy viết một câu bằng lời của bạn. Hàng nghìn bài chỉ khác nhau ở cái khóa sẽ bị coi là cày kéo, và người chịu thiệt là những ai thật sự đã làm việc.",
    "One step left" to "Còn một bước",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Chỉ những ngôn ngữ có bản dịch thực sự mới được liệt kê. Một bộ chọn cung cấp các ngôn ngữ nhưng đều hiển thị bằng tiếng Anh sẽ báo rằng ngôn ngữ của bạn được hỗ trợ, rồi cho thấy điều ngược lại ở màn hình tiếp theo.",
    "Opening a connection" to "Đang mở kết nối",
    "Opening your Solana wallet" to "Đang mở ví Solana của bạn",
    "Optional, and the part that actually counts." to
        "Không bắt buộc, nhưng đây mới là phần thực sự quan trọng.",
    "Passport at risk" to "Passport có nguy cơ",
    "Paste the link here and your name is attached to your key for good. This is the part people mean to do later and then do not." to
        "Dán liên kết vào đây và tên bạn gắn với khóa của bạn vĩnh viễn. Đây là phần người ta định để lát nữa làm rồi không làm.",
    "Paste the link to your post. It goes into your identity note, so the note points at the post and the post carries the key. Anyone can then check both ends against one key." to
        "Dán liên kết đến bài đăng của bạn. Liên kết này sẽ được đưa vào ghi chú danh tính của bạn, để ghi chú trỏ đến bài đăng và bài đăng chứa khóa. Sau đó, bất kỳ ai cũng có thể đối chiếu cả hai bằng cùng một khóa.",
    "Post your line, then come back and paste the link. That is what attaches your name to your key, and it is the half FLOP asked agents for." to
        "Hãy đăng dòng của bạn, rồi quay lại dán liên kết. Chính điều đó gắn tên bạn với khóa của bạn, và đó là nửa phần FLOP đã yêu cầu các tác nhân làm.",
    "Press Create again. Nothing was sent anywhere." to
        "Nhấn Tạo lần nữa. Chưa có gì được gửi đi.",
    "Press check in again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was posted." to
        "Hãy bấm điểm danh lần nữa. technocore.chat là dịch vụ công cộng và nó từ chối ghi khi đang bận, điều đó không liên quan gì tới ứng dụng này, tới máy của bạn hay tới khóa của bạn. Hai ba lần thử là chuyện bình thường. Chưa có gì được gửi đi.",
    "Press publish again. technocore.chat is a public service and it refuses writes when it is busy, which has nothing to do with this app, your phone or your key. Two or three attempts is normal. Nothing was published." to
        "Hãy bấm công bố lần nữa. technocore.chat là dịch vụ công cộng và nó từ chối ghi khi đang bận, điều đó không liên quan gì tới ứng dụng này, tới máy của bạn hay tới khóa của bạn. Hai ba lần thử là chuyện bình thường. Chưa có gì được công bố.",
    "Protect" to "Bảo vệ",
    "Protect it" to "Bảo vệ mục này",
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
    "Seven days without a record. Open the app to publish it again." to
        "Bảy ngày không có bản ghi. Hãy mở ứng dụng để đăng lại.",
    "Shipped a Technocore client for the Seeker" to
        "Đã phát hành một ứng dụng Technocore cho Seeker",
    "Show your private key" to "Hiển thị khóa riêng của bạn",
    "Sign a record now and this day is on your history for good." to
        "Ký một bản ghi ngay, và ngày hôm nay sẽ nằm trong lịch sử của bạn mãi mãi.",
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
    "That does not look like a link. It should start with https://" to
        "Đây có vẻ không phải là một liên kết. Liên kết phải bắt đầu bằng https://",
    "That was the last step. Your Passport is live. One thing left, and it is the part FLOP actually asked for: tell people what you did. The app writes the post for you at the bottom of this screen." to
        "Đó là bước cuối cùng. Passport của bạn đã hoạt động. Chỉ còn một việc, và đó là điều FLOP thực sự yêu cầu: kể cho mọi người bạn đã làm gì. Ứng dụng viết bài đăng cho bạn ở cuối màn hình này.",
    "The five steps built your identity. Nobody outside this phone knows it is yours yet. Step 06 below: write one line, post it, then come back and paste the link. That last part is what puts your name beside your key for good, and it is where people stop." to
        "Năm bước đã dựng nên danh tính của bạn. Ngoài chiếc máy này ra, chưa ai biết nó là của bạn. Bước 06 ở dưới: viết một dòng, đăng lên, rồi quay lại dán liên kết. Chính phần cuối đó đặt tên bạn cạnh khóa của bạn mãi mãi, và đó cũng là chỗ người ta dừng lại.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "Danh tính được tạo bên trong Seed Vault và niêm phong bằng StrongBox trên điện thoại.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Khóa được niêm phong trong bộ nhớ bảo mật của điện thoại này, sau đó được đọc lại và đối chiếu với danh tính của bạn.",
    "The link you paste goes into your identity note, at an address derived from your own key. Rooms are cleared within a day; the note is not." to
        "Liên kết bạn dán sẽ vào ghi chú danh tính của bạn, ở địa chỉ tính ra từ chính khóa của bạn. Phòng bị dọn trong vòng một ngày, ghi chú thì không.",
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
    "This app is free and there is nothing in it to buy. If it has been useful, kosa.skr is where a thank you goes." to
        "Ứng dụng này miễn phí và không có gì để mua. Nếu thấy hữu ích, bạn có thể gửi lời cảm ơn đến kosa.skr.",
    "This app rewrites your note every time you open it and every time you sign a record, so the seven days start again. Open it at least once a week and nothing is ever lost." to
        "Ứng dụng này ghi lại ghi chú mỗi khi bạn mở ứng dụng và mỗi khi bạn ký một bản ghi, nên thời hạn bảy ngày sẽ bắt đầu lại. Hãy mở ứng dụng ít nhất một lần mỗi tuần để không bao giờ mất gì.",
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Đây KHÔNG phải khóa ví Solana của bạn. Khóa của ví không bao giờ rời Seed Vault và ứng dụng này chưa từng thấy nó. Thứ bạn đang xem là một khóa riêng biệt, chỉ dùng để ký trên Technocore.",
    "This line is what makes the post yours. Everything under it is the proof." to
        "Chính câu này khiến bài đăng là của bạn. Mọi thứ bên dưới là bằng chứng.",
    "Three days left before it is deleted." to "Còn ba ngày trước khi ghi chú bị xóa.",
    "Three things, in this order: write your line, post it, then come back and paste the link. The last one is what makes it permanent, and it is the one people forget." to
        "Ba việc, theo thứ tự: viết câu của bạn, đăng lên, rồi quay lại dán liên kết. Việc cuối mới làm cho nó bền lâu, và đó cũng là việc người ta hay quên.",
    "Today cannot be added later" to "Hôm nay không thể thêm vào sau",
    "Told only when your identity note is days away from being deleted." to
        "Chỉ thông báo khi ghi chú danh tính của bạn sắp bị xóa trong vài ngày tới.",
    "Tomorrow is the last day." to "Ngày mai là ngày cuối cùng.",
    "Try again. Nothing was posted." to "Thử lại. Chưa có gì được đăng.",
    "Try again. Nothing was published." to "Thử lại. Chưa có gì được công bố.",
    "Two days left before it is deleted." to "Còn hai ngày trước khi ghi chú bị xóa.",
    "Unfinished setup" to "Thiết lập chưa xong",
    "Use the phone's language" to "Sử dụng ngôn ngữ của điện thoại",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Chờ một lát rồi nhấn lại để kiểm tra. Không nên xem đây là lỗi.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Chờ một lát rồi nhấn lại để kiểm tra. Gửi dưới dạng tin nhắn mới sẽ đăng công khai hai lần.",
    "What did you actually do?" to "Bạn thực sự đã làm gì?",
    "What is still provable" to "Những gì vẫn có thể chứng minh",
    "What recovery without a seed phrase costs" to
        "Cái giá của việc khôi phục mà không cần cụm từ hạt giống",
    "What to do and how often, why the identity expires, why this works on a Seeker, and what the catch is. Opens in your browser." to
        "Cần làm gì và bao lâu một lần, vì sao danh tính hết hạn, vì sao cách này hoạt động trên Seeker và có điều gì cần lưu ý. Mở trong trình duyệt của bạn.",
    "Write one line only you would write. Posts that differ from each other by nothing but a key get read as farming, and that lands on the people who did the work." to
        "Hãy viết một dòng mà chỉ bạn mới viết ra. Những bài chỉ khác nhau đúng một cái khóa sẽ bị coi là cày kéo, và người chịu thiệt là những ai thật sự đã làm việc.",
    "Yes. Something is already visible to others." to
        "Có. Một số nội dung đã hiển thị với người khác.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Bạn không cần tệp này để khôi phục. Chính ví Solana đã",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Bạn không cần mục này để khôi phục. Cùng một ví Solana sẽ dựng lại cùng một Passport trên bất kỳ điện thoại nào. Bản sao này dùng để sử dụng khóa ở nơi khác theo quyết định của bạn.",
    "You finished the five. The last one takes a minute." to
        "Bạn đã xong năm bước. Bước cuối chỉ mất một phút.",
    "You have already checked in" to "Bạn đã ghi bản ghi",
    "You have already left a record today." to "Hôm nay bạn đã để lại một bản ghi.",
    "You're all set" to "Đã hoàn tất",
    "Your Passport has no name on it" to "Passport của bạn chưa có tên",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Passport của bạn được tạo bên trong Seed Vault, kho khóa phần cứng của Seeker, nơi không thể trích xuất khóa. Sau đó, khóa được niêm phong bằng bộ nhớ bảo mật của Android trên điện thoại này. Việc ký diễn ra trong ứng dụng, không phải trong phần cứng, vì Android Keystore không thể giữ loại khóa này - do đó chúng tôi nói khóa được niêm phong, không phải được ký, trong phần cứng.",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passport của bạn được dẫn xuất từ một chữ ký do ví tạo trong Seed Vault, kho khóa phần cứng của Seeker. Khóa ví không bao giờ rời khỏi phần cứng đó. Khóa Passport được tính từ chữ ký này trong ứng dụng rồi được bộ nhớ bảo mật của Android niêm phong - được niêm phong, không phải được ký, trong phần cứng, vì Android Keystore không thể lưu loại khóa này.",
    "Your Passport is live" to "Passport của bạn đang hoạt động",
    "Your Passport is live and it is yours." to "Passport của bạn đã hoạt động và là của bạn.",
    "Your Passport is live and it is yours. One thing is left, and it is the one FLOP actually asked for: say so publicly, and link it back. Step 06 below." to
        "Passport của bạn đã hoạt động và là của bạn. Còn một việc, đúng việc mà FLOP đã yêu cầu: nói ra công khai và liên kết ngược lại. Bước 06 ở dưới.",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport của bạn đang hoạt động và bản ghi có chữ ký đầu tiên đã có trên Technocore. Bất kỳ ai cũng có thể xác minh và nó vẫn thuộc về bạn.",
    "Your Passport is live, it is yours, and your name is on it." to
        "Passport của bạn đã hoạt động, là của bạn, và mang tên bạn.",
    "Your Passport is live." to "Passport của bạn đang hoạt động.",
    "Your Passport is live. One step left." to "Passport của bạn đã hoạt động. Còn một bước.",
    "Your Passport is rebuilt from one wallet signature, which is why no seed phrase exists to lose. The same fact cuts the other way: any app that persuades your wallet to sign that exact sentence can rebuild this Passport. Read what a wallet asks you to sign, here and everywhere else." to
        "Passport của bạn được dựng lại từ một chữ ký ví duy nhất, nên không có cụm từ hạt giống nào để mất. Điều đó cũng đúng theo chiều ngược lại: bất kỳ ứng dụng nào thuyết phục được ví của bạn ký đúng câu đó đều có thể dựng lại Passport này. Hãy đọc kỹ những gì một ví yêu cầu bạn ký, ở đây và ở mọi nơi.",
    "Your Passport itself is not lost: the same wallet still gives the same identity, and signing a record now publishes the note back to the same address." to
        "Passport của bạn không bị mất: cùng một ví vẫn tạo ra cùng một danh tính, và việc ký một bản ghi lúc này sẽ đăng lại ghi chú tại cùng một địa chỉ.",
    "Your identity note expires soon" to "Ghi chú danh tính của bạn sắp hết hạn",
    "Your identity note has been deleted" to "Ghi chú danh tính của bạn đã bị xóa",
    "Your key is never sent anywhere. Only you can export it." to
        "Khóa của bạn không bao giờ được gửi đi đâu. Chỉ bạn mới có thể xuất khóa.",
    "Your key never leaves this phone." to "Khóa của bạn không bao giờ rời điện thoại này.",
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
    "agent: FLOP Passport for Seeker" to "tác nhân: FLOP Passport cho Seeker",
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
    "danger zone" to "khu vực nguy hiểm",
    "day streak" to "chuỗi ngày liên tiếp",
    "delete passport from this phone" to "xóa passport khỏi điện thoại này",
    "detail" to "chi tiết",
    "did anything go public?" to "có nội dung nào đã công khai không?",
    "done" to "xong",
    "failed" to "thất bại",
    "fetched again and matched exactly" to "đã tải lại và khớp hoàn toàn",
    "fetched from the server on opening" to "được tải từ máy chủ khi mở",
    "fingerprint" to "dấu vân tay",
    "flop-passport vault self-test" to "tự kiểm tra kho khóa flop-passport",
    "identity" to "danh tính",
    "identity note" to "ghi chú danh tính",
    "language {code}" to "ngôn ngữ {code}",
    "last connection" to "kết nối gần nhất",
    "linked" to "đã liên kết",
    "live" to "đang hoạt động",
    "live records" to "bản ghi đang công khai",
    "matched on our nonce, not just our key" to
        "khớp với nonce của chúng tôi, không chỉ với khóa",
    "no thanks, continue" to "không, cảm ơn, tiếp tục",
    "no, nothing was made public" to "không, chưa có gì được công khai",
    "nonce" to "nonce",
    "not found" to "không tìm thấy",
    "not yet" to "chưa đâu",
    "not yet - the note alone is a claim, not a proof" to
        "chưa - riêng ghi chú chỉ là một tuyên bố, không phải bằng chứng",
    "off" to "tắt",
    "on" to "bật",
    "open" to "mở",
    "our exact bytes, no wallet prefix" to "đúng các byte của chúng tôi, không có tiền tố ví",
    "passport for seeker" to "passport cho seeker",
    "pin it to your identity" to "ghim vào danh tính của bạn",
    "post it" to "đăng bài",
    "private key, 32 bytes, hex" to "khóa riêng, 32 byte, hex",
    "protect passport" to "bảo vệ passport",
    "publish identity" to "công bố danh tính",
    "publish these to my note" to "đăng vào ghi chú của tôi",
    "published" to "đã công bố",
    "publishing" to "đang công bố",
    "re-check with the server" to "kiểm tra lại với máy chủ",
    "re-checked when the app opened" to "đã kiểm tra lại khi mở ứng dụng",
    "records the server still holds" to "các bản ghi máy chủ vẫn còn lưu",
    "recovery" to "khôi phục",
    "room" to "phòng",
    "save my key" to "lưu khóa của tôi",
    "save to a file" to "lưu vào tệp",
    "say it another way" to "nói cách khác",
    "self test" to "tự kiểm tra",
    "send a tip" to "gửi tiền ủng hộ",
    "send a tip in {token}" to "gửi tiền ủng hộ bằng {token}",
    "send a tip to {name}" to "gửi tiền ủng hộ tới {name}",
    "sequence" to "trình tự",
    "settings" to "cài đặt",
    "sign and check in" to "ký và ghi bản ghi",
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
    "technocore.chat deletes anything with no write for seven days. Signing today rewrites your note and starts the seven days again." to
        "technocore.chat xóa mọi nội dung không được ghi thêm trong bảy ngày. Ký hôm nay sẽ ghi lại ghi chú của bạn và bắt đầu lại thời hạn bảy ngày.",
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
    "vault {level}" to "két {level}",
    "verified" to "đã xác minh",
    "verify it yourself" to "tự xác minh",
    "version" to "phiên bản",
    "vouched for" to "được chứng thực",
    "wallet" to "ví",
    "wallet linked" to "đã liên kết ví",
    "what this app never does" to "những điều ứng dụng này không bao giờ làm",
    "what to do" to "cần làm gì",
    "when" to "thời điểm",
    "with a wallet prefix, which is fine and pinned" to
        "có tiền tố ví, điều này hợp lệ và đã được cố định",
    "working" to "đang xử lý",
    "yes, a signed did-note line carries its hash" to
        "có, một dòng did-note có chữ ký chứa hash của nó",
    "yes, delete" to "có, xóa",
    "yes, something is already public" to "có, một số nội dung đã công khai",
    "your identity" to "danh tính của bạn",
    "your private key" to "khóa riêng của bạn",
    "{token} is preselected and you can switch it." to
        "{token} đã được chọn sẵn và bạn có thể đổi.",
)
