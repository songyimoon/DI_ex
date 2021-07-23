package service.library;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.LibraryCommand;
import model.LibraryDTO;
import repository.LibraryRepository;

public class LibraryModifyService {
   @Autowired
   LibraryRepository libraryRepository;
   
   public void libModify(LibraryCommand libraryCommand, HttpSession session) {
      LibraryDTO dto = new LibraryDTO();
      dto.setNoticeCon(libraryCommand.getNoticeCon());
      dto.setNoticeSub(libraryCommand.getNoticeSub());
      dto.setNoticeNo(libraryCommand.getNoticeNo());
      
      LibraryDTO dto2 = libraryRepository.libraryInfo(libraryCommand.getNoticeNo());   
      
      //이미 dto에 저장된 정보를 가져와서 오리지날넘버, 파일명, 파일사이즈를 저장해준다. 
      String original = dto2.getNoticeOrgFile();
      String store = dto2.getNoticeFile();
      String fileSize = dto2.getNoticeFileSize();
      String realPath = session.getServletContext().getRealPath("WEB-INF/view/library/upload");
      
      String [] fileNames = libraryCommand.getFileDel().split("/");
      if(!fileNames[0].equals("")) {
         String org = "";
         String str = "";
         String fsize = "";
         for(String s : fileNames) {
            org += s.split(",")[0]+",";
            str += s.split(",")[1]+",";
            fsize += s.split(",")[2]+",";      
         }
         int i = 0;
         if(!fileNames[0].equals("")) {
            for(String o : org.split(",")) {
               String or = o + ",";
               String sr = str.split(",")[i]+",";
               String fs = fsize.split(",")[i]+",";
               original = original.replace(or, ""); // 삭제할 부분을 공백으로 바꿔주면서 없앰
               store = store.replace(sr, "");
               fileSize = fileSize.replace(fs, "");
               File file = new File(realPath+"/"+str.split(",")[i]);
               if(file.exists()) file.delete();
               i++;
            }
         }
      }   // 파일추가
      String originalTotal="";
      String storeTotal="";
      String fileSizeTotal="";
      if(libraryCommand.getNoticeFile()[0].getOriginalFilename()!="") {
         for(MultipartFile mf : libraryCommand.getNoticeFile()) {
            String original1 = mf.getOriginalFilename();
            String originalExt1 = original1.substring(original1.lastIndexOf("."));
            String store1 = UUID.randomUUID().toString().replace("-", "")+originalExt1;
            String fileSize1 = Long.toString(mf.getSize());
            originalTotal += original1 + ",";
            storeTotal += store1 + ",";
            fileSizeTotal += fileSize1 + ",";
            File file = new File(realPath+"/"+store1); // 저장되어 있던거 + 
            try {mf.transferTo(file);} 
            catch (Exception e) {e.printStackTrace();}
         }
         dto.setNoticeOrgFile((original+originalTotal).replace("null", ""));
         dto.setNoticeFile((store+storeTotal).replace("null", ""));
         dto.setNoticeFileSize((fileSize+fileSizeTotal).replace("null", ""));
      }else { // 넘어온 추가파일이 없다면, 본래 가지고 있던 파일만 넘겨주기
         dto.setNoticeOrgFile(original);
         dto.setNoticeFile(store);
         dto.setNoticeFileSize(fileSize);
      }   
      libraryRepository.libModify(dto);   
   }
}