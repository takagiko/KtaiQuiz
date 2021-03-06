    KtaiQuiz

    Copyright (C) 2011 Koichi TAKAGI <takagiko.git (atmark) gmail.com>

このプログラムはフリーソフトウェアです。あなたはこれを、フリーソフトウェア財団によって発行されたGNU一般公衆利用許諾書(バージョン3か、それ以降のバージョンのうちどれか)が定める条件の下で再頒布または改変することができます。

このプログラムは有用であることを願って頒布されますが、*全くの無保証* です。商業可能性の保証や特定目的への適合性は、言外に示されたものも含め、全く存在しません。詳しくはGNU一般公衆利用許諾書をご覧ください。

あなたはこのプログラムと共に、GNU一般公衆利用許諾書のコピーを受け取っているはずです(gpl-3.0.txt)。もし受け取っていなければ、<http://www.gnu.org/licenses/> をご覧ください。 


このプログラムは、TomcatのようなJavaアプリケーションサーバ上で実行されるサーバサイドプログラムです。私は、このプログラムを Amazon web service (Linux 32bit)上の Java 6 と Tomcat 7.0.6 で動作させていました。

GitHub https://github.com/takagiko/KtaiQuiz でソースコードを公開しています。


【どのようなプログラムですか？】

パーティなどの参加者に、（主に携帯電話で）クイズを実施するためのシステムです。
このクイズの実施者（管理者）が、かなりシステムに詳しい（自分でサーバにwarファイルをデプロイできる）ことを想定しています。


【使い方・前準備】

１．src/main/resources/settings.xml が、出題する問題のファイルです。これを編集してください。

２．src/main/java/ktaiquiz/dto/ConditionDto.java の、public static final String SALT を、何でもよいので適当な文字列に変更してください。

３．src/main/java/ktaiquiz/action/DownloadURLAction.java の、public static final String URL を、ユーザ・管理者がアクセスするときのURLに変更してください。

４．サーバにデプロイした後、http://(サーバのアドレス)/downloadURL/ にアクセスして、ユーザ・管理者がアクセスするときのURL一覧を取得してください。

５．src/main/java/ktaiquiz/action/DownloadURLAction.java を消して（もしくは適当にリネームして）、再度デプロイし直してください。４．の方法でURL一覧が取得できなくなります。

６．４．でダウンロードしたテキストファイルの２行目以降が、ユーザ用URLです。印刷するなどしてユーザに配布する準備をしてください。


【使い方・当日】

１．前準備の６で準備したURLをユーザに配布してください。

２．管理者用URL（４．でダウンロードしたテキストファイルの１行目）にアクセスしてください。

３．ユーザがURLにアクセスし、ユーザ名を登録して準備ができたら、管理者が「第１問」の「受付中にする」をクリックすると、第１問が回答可能になります。
　※参考：「ログインユーザ：??人」の右の「別ウインドウで一覧」をクリックすると、登録が済んだユーザの一覧が表示できます。

４．回答を締め切るときは、現在回答中の次の問題の「受付前にする」をクリックすると、現在回答中の問題の回答が締め切られます。
　※参考：「リロード」をクリックすると、その時点で回答済みの人数が更新されます。
　※参考：「別ウインドウでグラフ表示」をクリックすると、回答の分布がグラフで表示されます。この操作は回答締切り前でも、締切り後でも可能です。

５．最後の問題の解答を締め切るときは、「受付終了状態にする」をクリックします。

６．「別ウインドウで結果発表」をクリックすると、１．得点順　２．回答に要した平均時間順　で順位が表示されます。
　※プロジェクタなどで参加者に見える状態で発表すると盛り上がりますが、URLに含まれるユーザ名とハッシュのみで認証しているので、参加者から管理者画面のURLが見えないようにしてください。

