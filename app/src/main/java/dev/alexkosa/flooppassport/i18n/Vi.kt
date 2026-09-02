package dev.alexkosa.flooppassport.i18n

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
    "A message signed by your Passport, posted to a quiet room and then read back to prove it landed." to
        "Một tin nhắn được Passport của bạn ký, gửi vào một phòng yên tĩnh rồi đọc lại để chứng minh đã được ghi nhận.",
    "A once-a-day reminder to leave today's signed record." to
        "Lời nhắc mỗi ngày một lần để để lại bản ghi đã ký hôm nay.",
    "A permanent note at an address derived from your key, so anyone can find and verify you later." to
        "Một ghi chú lâu dài tại địa chỉ được tạo từ khóa của bạn, để sau này bất kỳ ai cũng có thể tìm và xác minh bạn.",
    "A public note at an address derived from your key, so anyone can find and verify you later." to
        "Một ghi chú công khai tại địa chỉ được dẫn xuất từ khóa của bạn, để bất kỳ ai cũng có thể tìm và xác minh bạn sau này.",
    "A signed record has to be left by hand, and a missed day cannot be filled in later." to
        "Bản ghi đã ký phải được để lại thủ công, và không thể bổ sung sau cho ngày đã bỏ lỡ.",
    "A tip changes nothing about your Passport and nothing about any airdrop." to
        "Tiền ủng hộ không thay đổi gì về Passport của bạn hay bất kỳ airdrop nào.",
    "A tip changes nothing about your Passport, and nothing about any airdrop. It is a thank you, not a fee." to
        "Tiền ủng hộ không thay đổi gì về Passport của bạn hay bất kỳ airdrop nào. Đây là lời cảm ơn, không phải phí.",
    "About" to "Giới thiệu",
    "Accepted, but we could not read it back yet" to
        "Đã được chấp nhận, nhưng chưa thể đọc lại",
    "Activity" to "Hoạt động",
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
    "Deleting removes the Passport from this phone only. Anything already published may stay public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Việc xóa chỉ gỡ Passport khỏi điện thoại này. Mọi nội dung đã công bố có thể vẫn công khai, và cùng một ví sẽ tạo lại cùng một danh tính - vì vậy đây không phải là cách hoàn tác bất kỳ điều gì.",
    "Deleting removes the Passport from this phone only. Anything already published stays public, and the same wallet rebuilds the same identity - so this is not a way to undo anything." to
        "Thao tác xóa chỉ gỡ Passport khỏi điện thoại này. Mọi nội dung đã công bố vẫn công khai và cùng ví đó sẽ dựng lại cùng một danh tính - vì vậy đây không phải cách hoàn tác.",
    "Derived from a Seed Vault signature, sealed by StrongBox on device." to
        "Được dẫn xuất từ chữ ký Seed Vault, rồi được StrongBox niêm phong trên thiết bị.",
    "Derived from a signature my wallet made inside Seed Vault, then sealed by StrongBox." to
        "Được dẫn xuất từ chữ ký mà ví của tôi tạo trong Seed Vault, rồi được StrongBox niêm phong.",
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
    "FLOP asked agents to do something useful. A signed record is what proves you did, and a day without one is a day nobody can check later." to
        "FLOP yêu cầu các tác nhân làm điều gì đó hữu ích. Bản ghi đã ký là bằng chứng cho việc đó, và nếu một ngày không có bản ghi thì sau này không ai có thể kiểm tra ngày đó.",
    "Identity derived from your wallet signature" to "Danh tính được tạo từ chữ ký ví của bạn",
    "Identity note published, first check in signed and verified on Technocore." to
        "Đã công bố ghi chú danh tính, bản ghi đầu tiên đã được ký và xác minh trên Technocore.",
    "Identity note published, first check in verified on Technocore." to
        "Đã công bố ghi chú danh tính, bản ghi đầu tiên đã được xác minh trên Technocore.",
    "Identity note published, first check in verified." to
        "Đã công bố ghi chú danh tính, bản ghi đầu tiên đã được xác minh.",
    "It never asks for your wallet recovery phrase." to
        "Ứng dụng không bao giờ yêu cầu cụm từ khôi phục ví của bạn.",
    "It promises nothing about any airdrop, and never will." to
        "Ứng dụng không hứa hẹn gì về bất kỳ airdrop nào và sẽ không bao giờ làm vậy.",
    "Keep this file offline. Never send it to anyone, including the app author." to
        "Giữ tệp này ngoại tuyến. Không bao giờ gửi cho bất kỳ ai, kể cả tác giả ứng dụng.",
    "Keep your record going" to "Duy trì bản ghi của bạn",
    "Key born in Seed Vault, sealed by StrongBox on device." to
        "Khóa được tạo trong Seed Vault, rồi niêm phong bằng StrongBox trên thiết bị.",
    "Language" to "Ngôn ngữ",
    "Leave today's signed record on Technocore." to
        "Để lại bản ghi đã ký hôm nay trên Technocore.",
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
    "Nothing asked yet" to "Chưa có câu hỏi nào",
    "Nothing found. If you signed something and it is not here, the room has been trimmed past it - which is normal, and exactly why this screen exists." to
        "Không tìm thấy gì. Nếu bạn đã ký nội dung nhưng không thấy ở đây, phòng đã lược bỏ phần chứa nội dung đó - đây là điều bình thường và chính là lý do màn hình này tồn tại.",
    "Nothing signed today yet." to "Hôm nay chưa có nội dung nào được ký.",
    "Only languages with a real translation are listed. A picker offering languages that all render English would say your language is supported and then prove otherwise on the next screen." to
        "Chỉ những ngôn ngữ có bản dịch thực sự mới được liệt kê. Một bộ chọn cung cấp các ngôn ngữ nhưng đều hiển thị bằng tiếng Anh sẽ báo rằng ngôn ngữ của bạn được hỗ trợ, rồi cho thấy điều ngược lại ở màn hình tiếp theo.",
    "Opening a connection" to "Đang mở kết nối",
    "Opening your Solana wallet" to "Đang mở ví Solana của bạn",
    "Press Create again. Nothing was sent anywhere." to
        "Nhấn Tạo lần nữa. Chưa có gì được gửi đi.",
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
    "Read from technocore.chat just now, not from this phone. Rooms are trimmed as they grow, so this is what anyone would find today." to
        "Vừa được đọc từ technocore.chat, không phải từ điện thoại này. Các phòng được lược bớt khi lớn dần, nên đây là nội dung bất kỳ ai cũng sẽ tìm thấy hôm nay.",
    "Reading your note" to "Đang đọc ghi chú của bạn",
    "Reading your records" to "Đang đọc các bản ghi của bạn",
    "Ready" to "Sẵn sàng",
    "Remind me once a day" to "Nhắc tôi mỗi ngày một lần",
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
    "Talking to the service" to "Đang liên lạc với dịch vụ",
    "Thanks for building this" to "Cảm ơn vì đã xây dựng ứng dụng này",
    "That was the last step. Your Passport is live." to
        "Đó là bước cuối cùng. Passport của bạn đang hoạt động.",
    "The identity is born inside Seed Vault and sealed by StrongBox on the phone." to
        "Danh tính được tạo bên trong Seed Vault và niêm phong bằng StrongBox trên điện thoại.",
    "The key is sealed in this phone's secure storage, then read back and checked against your identity." to
        "Khóa được niêm phong trong bộ nhớ bảo mật của điện thoại này, sau đó được đọc lại và đối chiếu với danh tính của bạn.",
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
    "This is NOT your Solana wallet key. Your wallet's own key never leaves Seed Vault and this app has never seen it. What you are looking at is a separate key that signs only on Technocore." to
        "Đây KHÔNG phải khóa ví Solana của bạn. Khóa của ví không bao giờ rời Seed Vault và ứng dụng này chưa từng thấy nó. Thứ bạn đang xem là một khóa riêng biệt, chỉ dùng để ký trên Technocore.",
    "Try again. Nothing was posted." to "Thử lại. Chưa có gì được đăng.",
    "Try again. Nothing was published." to "Thử lại. Chưa có gì được công bố.",
    "Use the phone's language" to "Sử dụng ngôn ngữ của điện thoại",
    "Wait a moment and press it again to re-check. Do not treat this as a failure." to
        "Chờ một lát rồi nhấn lại để kiểm tra. Không nên xem đây là lỗi.",
    "Wait a moment and press it again to re-check. Sending it as a new message would post twice in public." to
        "Chờ một lát rồi nhấn lại để kiểm tra. Gửi dưới dạng tin nhắn mới sẽ đăng công khai hai lần.",
    "What is still provable" to "Những gì vẫn có thể chứng minh",
    "Yes. Something is already visible to others." to
        "Có. Một số nội dung đã hiển thị với người khác.",
    "You do not need this file to recover. The same Solana wallet that" to
        "Bạn không cần tệp này để khôi phục. Chính ví Solana đã",
    "You do not need this to recover. The same Solana wallet rebuilds the same Passport on any phone. This copy is for using the key somewhere else, on your own terms." to
        "Bạn không cần mục này để khôi phục. Cùng một ví Solana sẽ dựng lại cùng một Passport trên bất kỳ điện thoại nào. Bản sao này dùng để sử dụng khóa ở nơi khác theo quyết định của bạn.",
    "You have already checked in" to "Bạn đã ghi bản ghi",
    "You have already left a record today." to "Hôm nay bạn đã để lại một bản ghi.",
    "You're all set" to "Đã hoàn tất",
    "Your Passport is born inside Seed Vault, the Seeker's hardware key store, from which a key cannot be extracted. On this phone it is then sealed by Android's secure storage. Signing itself happens in the app, not in hardware, because Android Keystore cannot hold this kind of key - so we say sealed, not signed, in hardware." to
        "Passport của bạn được tạo bên trong Seed Vault, kho khóa phần cứng của Seeker, nơi không thể trích xuất khóa. Sau đó, khóa được niêm phong bằng bộ nhớ bảo mật của Android trên điện thoại này. Việc ký diễn ra trong ứng dụng, không phải trong phần cứng, vì Android Keystore không thể giữ loại khóa này - do đó chúng tôi nói khóa được niêm phong, không phải được ký, trong phần cứng.",
    "Your Passport is derived from one signature your wallet makes inside Seed Vault, the Seeker's hardware key store. The wallet key never leaves that hardware. The Passport key is computed from its signature in this app and then sealed by Android's secure storage - sealed, not signed, in hardware, because Android Keystore cannot hold this kind of key." to
        "Passport của bạn được dẫn xuất từ một chữ ký do ví tạo trong Seed Vault, kho khóa phần cứng của Seeker. Khóa ví không bao giờ rời khỏi phần cứng đó. Khóa Passport được tính từ chữ ký này trong ứng dụng rồi được bộ nhớ bảo mật của Android niêm phong - được niêm phong, không phải được ký, trong phần cứng, vì Android Keystore không thể lưu loại khóa này.",
    "Your Passport is live" to "Passport của bạn đang hoạt động",
    "Your Passport is live and your first signed record is on Technocore. Anyone can verify it, and it stays yours." to
        "Passport của bạn đang hoạt động và bản ghi có chữ ký đầu tiên đã có trên Technocore. Bất kỳ ai cũng có thể xác minh và nó vẫn thuộc về bạn.",
    "Your Passport is live." to "Passport của bạn đang hoạt động.",
    "Your key is never sent anywhere. Only you can export it." to
        "Khóa của bạn không bao giờ được gửi đi đâu. Chỉ bạn mới có thể xuất khóa.",
    "Your key never leaves this phone." to "Khóa của bạn không bao giờ rời điện thoại này.",
    "Your wallet signs one statement. It is not a transaction and moves no funds. The same wallet rebuilds the same Passport on any device." to
        "Ví của bạn ký một tuyên bố. Đây không phải giao dịch và không chuyển tiền. Cùng ví đó sẽ dựng lại cùng một Passport trên bất kỳ thiết bị nào.",
    "active days" to "ngày hoạt động",
    "activity" to "hoạt động",
    "address" to "địa chỉ",
    "agent: FLOP Passport for Seeker" to "tác nhân: FLOP Passport cho Seeker",
    "algorithm: Ed25519, did:key, 32-byte seed" to "thuật toán: Ed25519, did:key, seed 32 byte",
    "built by a community builder" to "do một nhà phát triển cộng đồng xây dựng",
    "cancel" to "hủy",
    "change" to "thay đổi",
    "checked" to "đã kiểm tra",
    "close" to "đóng",
    "connection" to "kết nối",
    "content" to "nội dung",
    "continue" to "tiếp tục",
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
    "floop-passport vault self-test" to "tự kiểm tra kho khóa floop-passport",
    "identity" to "danh tính",
    "identity note" to "ghi chú danh tính",
    "last connection" to "kết nối gần nhất",
    "live" to "đang hoạt động",
    "live records" to "bản ghi đang công khai",
    "matched on our nonce, not just our key" to
        "khớp với nonce của chúng tôi, không chỉ với khóa",
    "no thanks, continue" to "không, cảm ơn, tiếp tục",
    "no, nothing was made public" to "không, chưa có gì được công khai",
    "not found" to "không tìm thấy",
    "not yet - the note alone is a claim, not a proof" to
        "chưa - riêng ghi chú chỉ là một tuyên bố, không phải bằng chứng",
    "off" to "tắt",
    "on" to "bật",
    "our exact bytes, no wallet prefix" to "đúng các byte của chúng tôi, không có tiền tố ví",
    "passport for seeker" to "passport cho seeker",
    "private key, 32 bytes, hex" to "khóa riêng, 32 byte, hex",
    "protect passport" to "bảo vệ passport",
    "publish identity" to "công bố danh tính",
    "published" to "đã công bố",
    "re-check with the server" to "kiểm tra lại với máy chủ",
    "re-checked when the app opened" to "đã kiểm tra lại khi mở ứng dụng",
    "records the server still holds" to "các bản ghi máy chủ vẫn còn lưu",
    "recovery" to "khôi phục",
    "room" to "phòng",
    "save my key" to "lưu khóa của tôi",
    "save to a file" to "lưu vào tệp",
    "self test" to "tự kiểm tra",
    "send a tip" to "gửi tiền ủng hộ",
    "sequence" to "trình tự",
    "settings" to "cài đặt",
    "sign and check in" to "ký và ghi bản ghi",
    "sign today's record" to "ký bản ghi hôm nay",
    "signed" to "đã ký",
    "signed and verified against your DID" to "đã ký và xác minh theo DID của bạn",
    "storage" to "lưu trữ",
    "support the builder" to "ủng hộ nhà phát triển",
    "technocore.chat answered" to "technocore.chat đã phản hồi",
    "technocore.chat refused the note" to "technocore.chat đã từ chối ghi chú",
    "technocore.chat refused the signed write" to
        "technocore.chat đã từ chối bản ghi có chữ ký",
    "text" to "văn bản",
    "the same wallet rebuilds this identity anywhere" to
        "cùng ví đó dựng lại danh tính này ở bất kỳ đâu",
    "unconfirmed" to "chưa xác nhận",
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
)
