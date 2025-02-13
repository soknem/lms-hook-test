package co.istad.lms.features.media;

import co.istad.lms.features.media.dto.MediaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medias")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/upload-single", consumes = "multipart/form-data")
    MediaResponse uploadSingle(@RequestPart MultipartFile file) throws Exception {

        return mediaService.uploadSingle(file);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/upload-multiple", consumes = "multipart/form-data")
    List<MediaResponse> uploadMultiple(@RequestPart List<MultipartFile> files) {
        return mediaService.uploadMultiple(files);
    }

    @GetMapping("/{mediaName}")
    MediaResponse loadMediaByName(@PathVariable String mediaName) {
        return mediaService.loadMediaByName(mediaName);
    }

    @DeleteMapping("/{mediaName}")
    MediaResponse deleteMediaByName(@PathVariable String mediaName) {
        return mediaService.deleteMediaByName(mediaName);
    }

    @GetMapping(path = "/{mediaName}/download",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<?> downloadMediaByName(@PathVariable String mediaName) {
        System.out.println("Start download");
        Resource resource = mediaService.downloadMediaByName(mediaName);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + mediaName);
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }

}
