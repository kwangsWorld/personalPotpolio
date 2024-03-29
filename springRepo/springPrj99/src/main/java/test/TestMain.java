package test;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.gallery.dao.GalleryDao;
import com.kh.app.gallery.service.GalleryService;
import com.kh.app.gallery.vo.GalleryVo;

public class TestMain {

	public static void main(String[] args) {
		
		GalleryDao dao = new GalleryDao();
		SqlSessionTemplate sst = new SqlSessionTemplate(null);
		GalleryService service = new GalleryService(dao, sst);
		
		test01(service);
		test02(service);
	}
	
	private static void test02(GalleryService service) {
		//목록조회 잘 되나?
		List<GalleryVo> gvoList = service.list();
		
		if(gvoList.size() == 1) {
			System.out.println("[테스트: 작성하기] 성공");
		}else {
			System.out.println("[테스트: 작성하기] 실패");
		}
	}

	public static void test01(GalleryService service) {
		//작성하기 잘 되나???
		GalleryVo gvo = new GalleryVo();
		gvo.setTitle("제목01");
		gvo.setFullPath("D:/dev/zzz.png");
		gvo.setWriterNo("1");
		
		int result = service.write(gvo);
		
		if(result ==1) {
			System.out.println("[테스트: 작성하기] 성공");
		}else {
			System.out.println("[테스트: 작성하기] 실패");
		}
	}
	
}
