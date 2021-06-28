package main.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	
	static long nextId = 0;

	static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();
	
	
	public Collection<MemberDTO> selectAll() {
		return map.values(); // 맵에 있는 value값 다 가져오기
	}
	
	
	
	public void update(MemberDTO dto) {
		map.put(dto.getEmail(), dto); // map은 키가 있으면 수정하고 없으면 추가한다.
	}
	
	public void insert(MemberDTO dto) {
		dto.setId(++nextId); // 선행연산자
		map.put(dto.getEmail(), dto);
	}
	
	public MemberDTO selectByEmail(String email) {
		return map.get(email); // 키가 없으면 null 값을 보내주고 키가 있으면 value를 전달 (DTO) 
	}
}
