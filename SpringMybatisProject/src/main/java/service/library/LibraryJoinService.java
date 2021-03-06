package service.library;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.LibraryCommand;
import model.AuthInfoDTO;
import model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryJoinService {
	@Autowired
	LibraryRepository libraryRepository;
	public void libJoin(LibraryCommand libraryCommand, HttpSession session) {
		LibraryDTO dto = new LibraryDTO();
		dto.setNoticeCon(libraryCommand.getNoticeCon());
		dto.setNoticeSub(libraryCommand.getNoticeSub());
		dto.setNoticeKind("자료실");
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("authInfo");
		dto.setEmployeeId(authInfo.getGrade());
		
		String originalTotal="";
		String storeTotal="";
		String fileSizeTotal="";
		
		if(libraryCommand.getNoticeFile()[0].getOriginalFilename()!="") {
			for(MultipartFile mf : libraryCommand.getNoticeFile()) {
				String original = mf.getOriginalFilename();
				String originalExt = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "")+originalExt;
				String fileSize = Long.toString(mf.getSize());
				originalTotal += original + ",";
				storeTotal += store + ",";
				fileSizeTotal += fileSize + ",";
				String path = "WEB-INF/view/library/upload";
				String realPath = session.getServletContext().getRealPath(path);
				File file = new File(realPath+"/"+store);
					try {mf.transferTo(file);} 
					catch (Exception e) {e.printStackTrace();}
				dto.setNoticeOrgFile(originalTotal);
				dto.setNoticeFile(storeTotal);
				dto.setNoticeFileSize(fileSizeTotal);
			}
		}
		
		libraryRepository.libJoin(dto);
		
	}
}
